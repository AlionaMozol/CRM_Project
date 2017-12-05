package com.project.crm.services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.UUID;

public class GoogleDriveAPI {




        /**
         * Application name.
         */
        private static final String APPLICATION_NAME =
                "Drive API Java Quickstart";

        /**
         * Directory to store user credentials for this application.
         */
        private static final java.io.File DATA_STORE_DIR = new java.io.File( "./DriveJava/drive_sample");

        /**
         * Global instance of the {@link FileDataStoreFactory}.
         */
        private static FileDataStoreFactory dataStoreFactory;

        /**
         * Global instance of the JSON factory.
         */
        private static final JsonFactory JSON_FACTORY =
                JacksonFactory.getDefaultInstance();

        /**
         * Global instance of the HTTP transport.
         */
        private static HttpTransport httpTransport;

        /**
         * Global instance of the scopes required by this quickstart.
         * If modifying these scopes, delete your previously saved credentials
         * at ~/.credentials/drive-java-quickstart
         */
        private static final java.util.Collection<String> SCOPES =
                DriveScopes.all();

        static {
            try {
                httpTransport = GoogleNetHttpTransport.newTrustedTransport();
                dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
            } catch (Throwable t) {
                t.printStackTrace();
                System.exit(1);
            }
        }

        /**
         * Creates an authorized Credential object.
         *
         * @return an authorized Credential object.
         * @throws IOException
         */
      /*  public static Credential authorize() throws IOException {
            // Load client secrets.
            InputStream in =
                    com.project.crm.services.GoogleDriveAPI.class.getResourceAsStream("/client_secret.json");
            GoogleClientSecrets clientSecrets =
                    GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow =
                    new GoogleAuthorizationCodeFlow.Builder(
                            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                            .setDataStoreFactory(DATA_STORE_FACTORY)
                            .setAccessType("offline")
                            .build();
            Credential credential = new AuthorizationCodeInstalledApp(
                    flow, new LocalServerReceiver()).authorize("user");
            System.out.println(
                    "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
            return credential;
        }

        *//**
         * Build and return an authorized Drive client service.
         *
         * @return an authorized Drive client service
         * @throws IOException
         *//*
        public static Drive getDriveService() throws IOException {
            Credential credential = authorize();
            return new Drive.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }*/


    private static Credential authorize() throws Exception {
        // load client secrets
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                new InputStreamReader(GoogleDriveAPI.class.getResourceAsStream("/client_secret.json")));
        if (clientSecrets.getDetails().getClientId().startsWith("Enter")
                || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
            System.out.println(
                    "Enter Client ID and Secret from https://code.google.com/apis/console/?api=drive "
                            + "into drive-cmdline-sample/src/main/resources/client_secrets.json");
            System.exit(1);
        }
        // set up authorization code flow
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport,
                JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(dataStoreFactory).build();
        // authorize
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    public static Drive getDriveService() {
        Credential credential = null;
        try {
            credential = authorize();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Authorize troubles");
        }
        return new Drive.Builder(
                httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }



    public static String addPohotoToDrive(MultipartFile multipartFile) throws IOException {
            Drive driveService = getDriveService();
            File fileMetadata = new File();
            String folderId = "1T6MFpWCdnYIGdNxuwvkEnfqDBWldFfhI"; // folder id at google drive
            fileMetadata.setParents(Collections.singletonList(folderId));
            fileMetadata.setName(UUID.randomUUID().toString());
            java.io.File imageFile = new java.io.File(multipartFile.getOriginalFilename());
            multipartFile.transferTo(imageFile);
            FileContent mediaContent = new FileContent( "image/*",imageFile);
            File file = driveService.files().create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();
            System.out.println("File ID: " + file.getId());
            return file.getId();
        }




    }


