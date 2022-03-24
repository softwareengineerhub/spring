package com.app;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;

public class InfluxDB2ExampleLoop {

    public static void main(String[] args) throws Exception {
        // You can generate an API token from the "API Tokens Tab" in the UI
        String token = "aAPxoYga-oWn7AUbBC-BU9ptj58AeH6pDdc_TBh-aUPgbvEOWFfqo2l6Xtkt5E_wq9fncIh-ImSC_IAN-2hHZg==";
        String bucket = "mybucket";
        String org = "mycompany";

        InfluxDBClient client = InfluxDBClientFactory.create("http://localhost:8086", token.toCharArray());

        String data = "mem,host=host1 used_percent=41.43234543";
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writeRecord(bucket, org, WritePrecision.NS, data);

        Thread.sleep(5000);

        data = "mem,host=host1 used_percent=32.43234543";
        writeApi = client.getWriteApiBlocking();
        writeApi.writeRecord(bucket, org, WritePrecision.NS, data);

        Thread.sleep(5000);

        data = "mem,host=host1 used_percent=24.43234543";
        writeApi = client.getWriteApiBlocking();
        writeApi.writeRecord(bucket, org, WritePrecision.NS, data);

        Thread.sleep(5000);

        client.close();

    }

}
