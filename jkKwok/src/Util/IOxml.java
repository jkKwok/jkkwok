/*
 * Copyright (C) 2016 Kwok
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Kwok
 */
public class IOxml {

    public String filename_;

    public IOxml(String filename) {
        this.filename_ = filename;
    }

    public String read(String element) throws FileNotFoundException, IOException, NullPointerException {
        File file = new File(filename_);
        Properties prop = new Properties();
        FileInputStream fileInput = new FileInputStream(file);
        prop.loadFromXML(fileInput);
        String details = prop.getProperty(element);
        if (details.equals(Constants.EMPTY_STRING)) {
            return Constants.EMPTY_STRING;
        } else {
            return details;
        }
    }

    public void write(Properties properties) throws FileNotFoundException, IOException {
        File file = new File(filename_);
        FileOutputStream fileOut = new FileOutputStream(file);
        properties.storeToXML(fileOut, Constants.ALIAS_COMMENT_TAG);
    }
}
