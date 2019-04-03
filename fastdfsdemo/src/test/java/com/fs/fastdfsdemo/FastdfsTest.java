package com.fs.fastdfsdemo;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

public class FastdfsTest {

    @Test
    public void testdfs() throws IOException, MyException {
        ClientGlobal.init("/D/workspace/springcloudws/ws02/EpcData/fastdfsdemo/src/main/resources/fdfs_client.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        String[] strings = storageClient.upload_file("/D/car.jpg", "jpg", null);
        for (String str : strings) {
            System.out.println(str);
        }
    }

}
