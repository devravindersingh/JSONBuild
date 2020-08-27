# JSONBuild

JSONBuild is a restApi for delivering a Json based upon a api request, consisting of select params, where clause and table name.

## Request Accepted by api
```json
	"whereClause": "whole where clause",
	"selectParam": "column names to select separated by ',' ",
	"tableName": "table name"
	
```

## Installation

Importing project in STS/Eclipse as Maven project. This will install all the dependencies needed.

* This project works on MySQL
* You can make it work with other databases aswell.
* Add required DB dependency in Pom.xml
* Modify Datasource bean in JDBCcnfig as per the db in config Package.
* Select query used only returns 1st row. So change it aswell as per your db.

 

## Usage

* Run as spring boot app.
* Open postman and fire post req at localhost:/portNo/getJson.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
