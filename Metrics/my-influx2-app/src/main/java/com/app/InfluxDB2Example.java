package com.app;

import java.time.Instant;
import java.util.List;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxTable;

public class InfluxDB2Example {

    public static void main(String[] args) {
        // You can generate an API token from the "API Tokens Tab" in the UI
        String token = "aAPxoYga-oWn7AUbBC-BU9ptj58AeH6pDdc_TBh-aUPgbvEOWFfqo2l6Xtkt5E_wq9fncIh-ImSC_IAN-2hHZg==";
        String bucket = "mybucket";
        String org = "mycompany";

        InfluxDBClient client = InfluxDBClientFactory.create("http://localhost:8086", token.toCharArray());


        String data = "mem,host=host1 used_percent=23.43234543";
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writeRecord(bucket, org, WritePrecision.NS, data);


        Point point = Point
                .measurement("mem")
                .addTag("host", "host1")
                .addField("used_percent", 23.43234543)
                .time(Instant.now(), WritePrecision.NS);

        writeApi = client.getWriteApiBlocking();
        writeApi.writePoint(bucket, org, point);



        client.close();

    }

}
