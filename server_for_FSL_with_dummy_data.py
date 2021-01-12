from flask import Flask, json

companies = {"farmStoreData":[{"id": 1, "name": "Farm Store 1", "zip": "1234", 
    "town":"Graz","street":"Wiener Strasse 5", "latitude":3.3234, "longitude":4.1234,
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
    "town":"Noerning","street":"Noerning 4", "latitude":22.3234, "longitude":10.1234,
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
    ]},
       {"id": 2, "name": "Kuchelbauer", "zip": "8250", 
    "town":"Vorau","street":"Riegersbach Weg 33", "latitude":47.425520, "longitude":15.883470,
    "openingHours":[
        {"day":"Mo","hours":"07:00-22:00"},  
        {"day":"Tu","hours":"07:00-22:00"},
        {"day":"We","hours":"07:00-22:00"},
        {"day":"Th","hours":"07:00-22:00"},
        {"day":"Fr","hours":"07:00-22:00"},
        {"day":"Sa","hours":"07:00-22:00"},
        {"day":"Su","hours":"07:00-20:00"},
    ],
    "products":[ 
        {"type":"apple wine","costPerUnit":"3.99","unit":"l"},
        {"type":"Pumpkinseeds","costPerUnit":"2.50","unit":"package"},
        {"type":"Apple juice","costPerUnit":"1.99","unit":"l"},
        {"type":"Schnaps Marille","costPerUnit":"15.00","unit":"bottle"},
        {"type":"Schnaps Obstler","costPerUnit":"12.00","unit":"bottle"}
    ]}
]}

companies2 = [{"id": 1, "name": "Farm Store 1", "zip": "1234", 
    "town":"Graz","street":"Wiener Strasse 5",},
       {"id": 2, "name": "Farm Store 2", "zip": "6789", 
    "town":"Noerning","street":"Noerning 4"}
]

asdf = {}

onecompany = {"id": 1, "name": "Farm Store 1", "zip": "1234", 
    "town":"Graz","street":"Wiener Strasse 5",
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
    ]}

    
api = Flask(__name__)

@api.route('/onecompany', methods=['GET'])
def get_companies():
  return json.jsonify(onecompany)

@api.route('/multiplecompanies', methods=['GET'])
def get_multiplecompanies():
  return json.jsonify(companies)

@api.route('/test', methods=['GET'])
def test():
  return json.jsonify(asdf)

if __name__ == '__main__':
    api.run()