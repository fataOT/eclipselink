/*******************************************************************************
 * Copyright (c) 1998, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     tware, ssmith = 1.0 - Initialize Persistence in OSGI
 ******************************************************************************/  
package org.eclipse.persistence.internal.jpa.deployment.osgi;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.internal.jpa.deployment.JPAInitializer;
import org.eclipse.persistence.internal.jpa.deployment.PersistenceInitializationHelper;

import org.osgi.framework.Bundle;

/**
 * Overrides the default persistence initialization behavior to allow classloaders to be obtained
 * from their appropriate bundle
 * 
 * @see PersistenceInitialization helper
 * 
 * @author tware
 *
 */
public class OSGiPersistenceInitializationHelper extends PersistenceInitializationHelper {

    public static final String EQUINOX_INITIALIZER_NAME = "org.eclipse.persistence.internal.jpa.deployment.osgi.equinox.EquinoxInitializer";
    
    // these maps are used to retrieve the classloader used for different bundles
    private static Map<String, Bundle> puToBundle = Collections.synchronizedMap(new HashMap<String,Bundle>());
    private static Map<Bundle, String[]> bundleToPUs = Collections.synchronizedMap(new HashMap<Bundle, String[]>());
    
    /**
     * Add a bundle to the list of bundles managed by this persistence provider
     * The bundle is indexed so it's classloader can be accessed
     * @param bundle
     * @param persistenceUnitNames
     */
    public static void addBundle(Bundle bundle, String[] persistenceUnitNames) {
        for (int i = 0; i < persistenceUnitNames.length; i++) {
            String name = persistenceUnitNames[i];
            puToBundle.put(name, bundle);
        }
        bundleToPUs.put(bundle, persistenceUnitNames);
    }

    /**
     * Removed a bundle from the list of bundles managed by this persistence provider
     * This typically happens on deactivation.
     * @param bundle
     */
    public static void removeBundle(Bundle bundle) {
        String[] persistenceUnitNames = bundleToPUs.remove(bundle);
        if (persistenceUnitNames != null) {
            for (int i = 0; i < persistenceUnitNames.length; i++) {
                String name = persistenceUnitNames[i];
                puToBundle.remove(name);
            }
        }
    }

    public static ClassLoader getBundleClassLoader(Bundle bundle)  {
        Class loadClass = null;
        try {
            String activatorClassName = (String) bundle.getHeaders().get("Bundle-Activator");
            if (activatorClassName == null) {
                throw new RuntimeException("Bundle Activator Class not specified!");
            } else {
                loadClass = bundle.loadClass(activatorClassName);
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot obtain class loader from bundle");
        }
        ClassLoader classLoader = loadClass.getClassLoader();
        return classLoader;
    }

    /**
     * Answer the classloader to use to create an EntityManager.
     * If a classloader is not found in the properties map then 
     * attempt to locate one in the bundle registry.
     * 
     * @param emName
     * @param properties
     * @return ClassLoader
     */
    public ClassLoader getClassLoader(String emName, Map properties) {
        ClassLoader bundleClassLoader = null;
        if (properties != null) {
            bundleClassLoader = (ClassLoader)properties.get(PersistenceUnitProperties.CLASSLOADER);
        }
        if (bundleClassLoader == null) {
            Bundle bundle = puToBundle.get(emName);
            if (bundle == null) {
                //TODO replace with EclipseLink Exception
                throw new RuntimeException(
                        "Bundle providing Persistence Unit '" + emName
                                + "' not found.");
            }
            bundleClassLoader = getBundleClassLoader(bundle);
        }
        return bundleClassLoader;
    }
            
    /**
     * Get the initializer class
     * Here we will attempt to build an EquinoxInitializer.  It will only be available if the org.eclipse.persistence.jpa.equinox
     * fragment is available.  Else, we will return a standard OSGi initializer
     * 
     */
    public JPAInitializer getInitializer(ClassLoader classLoader, Map m){
        // TODO: Find a cleaner way to use fragments
        try{
            // try to build the Equinox initializer.  If it is available, we will build it otherwise
            // we will assume generic OSGI
            Class initializerClass = Class.forName(OSGiPersistenceInitializationHelper.EQUINOX_INITIALIZER_NAME);
            Class[] argTypes = new Class[]{ClassLoader.class, Map.class, PersistenceInitializationHelper.class};
            Object[] args = new Object[]{classLoader, m, this};
            JPAInitializer initializer = (JPAInitializer)initializerClass.getConstructor(argTypes).newInstance(args);
            return initializer;
        } catch (Exception e){};
        return new OSGiInitializer(classLoader);
    }

}
