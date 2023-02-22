#!/bin/bash

SERVER_HOME=$(pwd)
NOW=$(date +'%Y%m%d%H%M')
APPLICATION=devblog-0.0.1-SNAPSHOT.jar

# Create directory
mkdir -p version/$NOW

# Move jar and deploy script
mv $SERVER_HOME/$APPLICATION $SERVER_HOME/version/$NOW
mv $SERVER_HOME/deploy.sh $SERVER_HOME/version/$NOW

# Stop application
if [ -f $SERVER_HOME/current/application.pid ];then
  kill -9 $(cat $SERVER_HOME/current/application.pid)
  rm $SERVER_HOME/current/application.pid
fi

# Remove current
if [ -d $SERVER_HOME/current ];then
  rm -r $SERVER_HOME/current
fi

# Create symbolic link
ln -s $SERVER_HOME/version/$NOW $SERVER_HOME/current

# cd
cd $SERVER_HOME/current

# Execute application
nohup java -jar $APPLICATION >> spring.out 2>&1 & echo $! > application.pid
