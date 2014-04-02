/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import java.io.File;
import javax.swing.filechooser.FileFilter;



/**
 *
 * @author Joseph
 */
public class Utils {
    
    public static FileFilter getFileFilter(){
        return new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()){
                    return true;
                }
                return isExtValid(f);
            }

            @Override
            public String getDescription() {
                return "Archivo de imagen *.jpeg";
            }
        };
    }
    
    public static boolean isExtValid(File pFile){
        String s = pFile.getName();
        int i = pFile.getName().lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            s = pFile.getName().substring(i+1).toLowerCase();
            return s.compareTo("jpg") == 0 || s.compareTo("jpeg") == 0;
        } else {
            return false;
        }
    }
    
}
