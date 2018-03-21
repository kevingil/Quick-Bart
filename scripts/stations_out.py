########################################
#script to parse data from the BART api#
########################################

from xml.dom import minidom
import urllib2

api = 'http://api.bart.gov/api/stn.aspx?cmd=stns&key=MW9S-E7SL-26DU-VV8V'
xml = minidom.parse(urllib2.urlopen(api))
itemlist = xml.getElementsByTagName('name')

#testing data accuracy by getting station count
#print(len(itemlist))

for station in itemlist:
    print(station.childNodes[0].nodeValue)
