# talkme-shop-api

## Requirments
Java, Spring boot 2, MySQL 5+, JPA or Hibernate 5+ to work with the database, Tomcat, database with indexes and links and close to 3rd normal form


## Task
The database is designed by the subject.
Authentication on the server:
https://developers.admitad.com/ru/doc/api_ru/auth/auth-client/
curl -H 'Authorization: Basic [token]' -X POST https://api.admitad. com/token/ -d 'grant_type=[type]&client_id=[client_id]&scope=[scope]'
From here we get access_token and refresh_token. Do not request new tokens unless necessary (i.e. until the old one is expired).

refresh_token - is used to refresh access_token -
https://developers.admitad.com/ru/doc/api_ru/auth/auth-refresh-token/

Next we are requesting programs:
https://developers.admitad.com/ru/doc/api_ru/methods/advcampaigns/advcampaigns-website-list/
curl -L -H 'Authorization: [token]' -X GET https://api.admitad.com/advcampaigns/website/2090016/?limit=[number]

Programs are stored in the database with a certain periodicity (adding and then updating).

The important things from the program are the title, the action details, the image, the categories (the nesting is not important, it is the category set itself), the shopping URL (gotolink) and the main feed of the products (products_xml_link).

The products are also uploaded to the database - description - https://support.admitad.com/hc/ru/articles/4405920538897-%D0%A2%D0%BE%D0%B2%D0%B0%D1%80%D0%BD%D1%8B%D0%B9-%D1%84%D0%B8%D0%B4

Important things in products are title, model, price, images, URL for buying.

We load the stores and products with a certain periodicity (it is set in the config).

We make a restart service to get the stores from our database. Paged.
And do a search - it returns the found products (search by model and name) from our database. The results are returned page by page.

Do admin (with login - logins for login just stored in the database - managing them is not included in the test task) - in the admin edit list of categories (actually name and picture).

And do rest to get these categories.
