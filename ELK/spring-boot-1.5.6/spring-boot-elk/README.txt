1) Use elasticsearch-6.5.1
bin\elasticsearch.bat

2) Use Kibana-6.5.1
update config\kibana.yml
	elasticsearch.hosts: ["http://localhost:9200"]
run kibana	
	bin\kibana.bat

3) Use logstash-6.5.1
Create config:
	config/logstash-sample.conf
Run:
	bin\logstash -f logstash.conf
	
4) Run application and go to URL
	http://localhost:8080/elk

Check logs are comming:
http://127.0.0.1:9200/_cat/indices/?v
http://127.0.0.1:9200/logstash-2023.06.08/_search

5) Kibana:
http://localhost:5601/

Management -> Index Patterns
And put  logstash-*

Then go to Discover --> set up refresh interval each 10 sec.
Add filed --> message
Generate few more logs and try to find them in Kibana 	
	
	