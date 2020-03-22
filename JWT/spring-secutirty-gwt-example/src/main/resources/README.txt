1) http://localhost:9192/welcome
POST:
{"userName":"denis","password":"1"}

response:
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZW5pcyIsImlhdCI6MTU4NDg5MjI4MCwiZXhwIjoxNTg0ODkyMzQwfQ.gSLht4nw3neP8iXq9YS-_Z_ubnNGKXtm76OfS1FWJKE



2) http://localhost:9192/authenticate
GET:
Header:
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZW5pcyIsImlhdCI6MTU4NDg5MjI4MCwiZXhwIjoxNTg0ODkyMzQwfQ.gSLht4nw3neP8iXq9YS-_Z_ubnNGKXtm76OfS1FWJKe

response:
page content