# my-retail-service

Documentation Steps/Assumptions:::


1.create schema in your local mysql db- "my_retail"


2.db configurations are in application.properties file(db endpoint can be changed there as per different environments)


3.If unable to create schema,please comment out mysql and spring-jpa dependencies from pom.xml


4.compile: mvn clean install


5.run: mvn spring-boot:run


6.At your local rest client-
HIT GET http://localhost:8080/product/13860428 (response is tested for this id-you can use any other id if you think the external API provided in the requirements has data for it)




7-Mocked Save API
HIT POST http://localhost:8080/product/13860428 with request body-
{
    "id": 13860428,
    "product": {
        "product": {
            "item": {
                "dpci": "058-34-0436",
                "upc": "025192110306",
                "buy_url": "https://www.target.com/p/the-big-lebowski-blu-ray/-/A-13860428",
                "country_of_origin": "US",
                "relationship_type_code": "Title Authority Child",
                "subscription_eligible": false,
                "product_classification": {
                    "product_type": "542",
                    "product_type_name": "ELECTRONICS",
                    "item_type_name": "Movies"
                }
            }
        }
    },
    "price": {
        "value": 13.49,
        "currency_code": "USD"
    }
}



8-Price data is mocked as per requirements assuming an external API would provide for it



9-Error Handling is not yet in place as it is completely dependent on external API response codes;
this can be integrated accordingly once we have all those codes in hand.
