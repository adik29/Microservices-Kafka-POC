# SB-kafka-real-world-project
# POC for Client Interview

# Required latest version of Java.

# Required SQL database.

# DOWNLOAD AND INSTALL KAFKA
https://dlcdn.apache.org/kafka/3.2.0/...

# START THE KAFKA ENVIRONMENT
  Start the ZooKeeper service
  .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

  Start the Kafka broker service 
  .\bin\windows\kafka-server-start.bat .\config\server.properties
 
 # Execute kafka-producer-wikimedia
 and then Execute Kafka-consumer-database-wikimedia
 
 # Expected output: Data from Wikimedia website will be consumed by producer and 
  will be sent to kafka broker and then consumer will consume that data and will store 
  in SQL database.
