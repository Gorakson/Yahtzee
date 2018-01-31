/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.interfaces;

/**
 * Something that can be saved as a file.
 * 
 * @author Thomas Pfaffinger
 * @version 1.0
 *
 */
public interface Saveable {
    /**
     * Saves the object at the specified location.
     * @param path The path.
     */
    void save(String path);
}
