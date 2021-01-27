package com.example.demo;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TempTest
{
    public static void main(String[] args) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException
    {
        String ak = "minioadmin";
        String sk = "minioadmin";
        String endpoint = "http://bpdev.sinosun.com:9000";

        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials("minioadmin", "minioadmin")
                        .build();

        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("response-content-type", "image/png");

        String url =
                minioClient.getPresignedObjectUrl(
                        GetPresignedObjectUrlArgs.builder()
                                .method(Method.PUT)
                                .bucket("bmallba")
                                .object("222.jpg")
                                .expiry(1, TimeUnit.DAYS)
                                .extraHeaders(reqParams)
                                .build());

        System.out.println(url);
    }
}
