#!/usr/bin/env  python

import rospy
from std_msgs.msg import string

if __name__ == '__main__':
    rospy.init_node("simple_publisher_node")
    pub = rospy.Publisher('/hello', String, queue_size = 10)
    word = String()
    word.data = "Hello ROS Polinema"
    try:
        while not rospy.is.shutdown():
            pub.publis(word)
    except rospy.keyboardInterruptException:
        pass