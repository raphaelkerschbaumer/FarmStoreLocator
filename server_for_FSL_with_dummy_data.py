from flask import Flask, json

companies = [
    {"id": 1, "name": "Farm Store 1", "zip": "1234", 
    "town":"Graz","street":"Wiener Straße 5",
    "openingHours":[
        {"day":"Mo","hours":"08:00-18:00"},  
        {"day":"Tu","hours":"08:00-18:00"},
        {"day":"We","hours":"08:00-18:00"},
        {"day":"Th","hours":"08:00-18:00"},
        {"day":"Fr","hours":"08:00-18:00"},
        {"day":"Sa","hours":"08:00-18:00"},
        {"day":"Su","hours":"08:00-18:00"},
    ],
    "products":[ 
        {"type":"potato","costPerUnit":"3.99","unit":"kg"},
        {"type":"pumpkin","costPerUnit":"1.50","unit":"piece"},
        {"type":"carrots","costPerUnit":"2.00","unit":"kg"}
    ]},
       {"id": 2, "name": "Farm Store 2", "zip": "6789", 
    "town":"Nörning","street":"Nörning 4",
    "openingHours":[
        {"day":"Mo","hours":"00:00-24:00"},  
        {"day":"Tu","hours":"00:00-24:00"},
        {"day":"We","hours":"00:00-24:00"},
        {"day":"Th","hours":"00:00-24:00"},
        {"day":"Fr","hours":"00:00-24:00"},
        {"day":"Sa","hours":"00:00-24:00"},
        {"day":"Su","hours":"00:00-24:00"},
    ],
    "products":[ 
        {"type":"apple wine","costPerUnit":"3.99","unit":"l"},
        {"type":"carrots","costPerUnit":"2.50","unit":"kg"}
    ]}
]
    
api = Flask(__name__)

@api.route('/companies', methods=['GET'])
def get_companies():
  return json.dumps(companies)

if __name__ == '__main__':
    api.run()