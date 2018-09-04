#!/bin/bash

(
 cd /home/ec2-user/0831
 cp -p "$1" backup."$1"
)
