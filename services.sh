kill -9 $(cat etc/services | grep 9082| awk '{print $7}'| cut -d'/' -f1)
