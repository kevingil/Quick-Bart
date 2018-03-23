########################################
#script to parse data from the BART api#
# TODO -I think stn_code needs to be lowercase\
#      -
########################################

from xml.dom import minidom
import urllib2

api = 'http://api.bart.gov/api/stn.aspx?cmd=stns&key=MW9S-E7SL-26DU-VV8V'
xml = minidom.parse(urllib2.urlopen(api))
stn_name = xml.getElementsByTagName('name')
stn_code = xml.getElementsByTagName('abbr')
stn_lat = xml.getElementsByTagName('gtfs_latitude')
stn_lon = xml.getElementsByTagName('gtfs_longitude')

#making strings. this fixed the unicode string bug
stn_name_out = ""
stn_code_out = ""
stn_location_api = ""
stn_map = ""
stn_map_reverse = ""

#STATIONS
for s in stn_name:
    stn_name_out = stn_name_out + "\"" + s.childNodes[0].nodeValue + "\", "

#STATION CODES
for a in stn_code:
    stn_code_out = stn_code_out + "\"" + a.childNodes[0].nodeValue + "\", "

#STAION_LOCATION_API
for i in range(46):
    abr = stn_code[i].childNodes[0].nodeValue
    lat = stn_lat[i].childNodes[0].nodeValue
    lon = stn_lon[i].childNodes[0].nodeValue
    stn_location_api = stn_location_api + "put(\"" + abr + "\", \"" + lat + ", " + lon + "\"); \n"

#STATION_MAP
for i in range(46):
    name = stn_name[i].childNodes[0].nodeValue
    abbr = stn_code[i].childNodes[0].nodeValue
    stn_map = stn_map + "put(\"" + name + "\", \"" + abbr + "\"); \n"

#REVERSE_STATION_MAP
for i in range(46):
    name = stn_name[i].childNodes[0].nodeValue
    abbr = stn_code[i].childNodes[0].nodeValue
    stn_map_reverse = stn_map_reverse + "put(\"" + abbr + "\", \"" + name + "\"); \n"

#PRINTING
print(stn_name_out)
print(stn_code_out)
print(stn_location_api)
print(stn_map)
print(stn_map_reverse)
