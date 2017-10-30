package com.project.crm.xml;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

    public class ConfigParser {

        private String driver;
        private String url;
        private String login;
        private String password;

        private final String TAG_URL = "url";
        private final String TAG_LOGIN = "login";
        private final String TAG_PASSWORD = "password";
        private final String TAG_DRIVER = "driver";
        private final String TAG_BDCONNECTION = "bdconnection";

        public void parseConfig(String xmlDoc) throws SAXException, IOException,
                ParserConfigurationException {
            File configFile = new File(xmlDoc);
            InputStream input = null;
            if (configFile.exists()) {
                input = new FileInputStream(configFile);
            } else {
                input = ConfigParser.class.getClassLoader().getResourceAsStream(
                        xmlDoc);
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            this.process(doc);
        }

        private void process(Document doc) {
            Element element = (Element) doc.getElementsByTagName(TAG_BDCONNECTION)
                    .item(0);
            url = element.getElementsByTagName(TAG_URL).item(0).getChildNodes()
                    .item(0).getNodeValue();
            login = element.getElementsByTagName(TAG_LOGIN).item(0).getChildNodes()
                    .item(0).getNodeValue();
            password = element.getElementsByTagName(TAG_PASSWORD).item(0)
                    .getChildNodes().item(0).getNodeValue();
            driver = element.getElementsByTagName(TAG_DRIVER).item(0)
                    .getChildNodes().item(0).getNodeValue();
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getUrl() {
            return url;
        }

        public String getDriver() {
            return driver;
        }
}
