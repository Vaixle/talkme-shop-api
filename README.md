# talkme-shop-api
[![Project Status: WIP – Initial development is in progress, but there has not yet been a stable, usable release suitable for the public.](https://www.repostatus.org/badges/latest/wip.svg)](https://www.repostatus.org/#wip)
[![GitHub](https://img.shields.io/github/license/Vaixle/talkme-shop-api)](https://github.com/Vaixle/talkme-shop-api/blob/main/LICENSE)

## Conntents:

- [Task](#Task) 
    - [Requirments](#Requirments) 
    - [Authentication on the server](#Authentication-on-the-server) 
    - [Requesting shops](#Requesting-shops) 
    - [Upload products](#Upload-products)
    - [Schedule upload](#Schedule-upload)
    - [Add admin role](#Add-admin-role)
    - [Rest service](#Rest-service)
- [Solution](#Solution)
- [API](#Solution)

### Task
The database is designed by the subject.

#### Requirments
Java, Spring boot 2, MySQL 5+, JPA or Hibernate 5+ to work with the database, Tomcat, database with indexes and links and close to 3rd normal form

#### Authentication on the server:
---
> https://developers.admitad.com/ru/doc/api_ru/auth/auth-client/
```
curl -H 'Authorization: Basic [token]' -X POST https://api.admitad. com/token/ -d 'grant_type=[type]&client_id=[client_id]&scope=[scope]'
```
From here we get `access_token` and `refresh_token`. Do not request new tokens unless necessary (i.e. until the old one is expired).

`refresh_token` - is used to refresh `access_token` -
> https://developers.admitad.com/ru/doc/api_ru/auth/auth-refresh-token/

#### Requesting shops:
---
> https://developers.admitad.com/ru/doc/api_ru/methods/advcampaigns/advcampaigns-website-list/
```
curl -L -H 'Authorization: [token]' -X GET https://api.admitad.com/advcampaigns/website/2090016/?limit=[number]
```

- Shops are stored in the database with a certain periodicity (adding and then updating).
- The important things from the program are the title, the action details, the image, the categories (the nesting is not important, it is the category set itself), the shopping URL (gotolink) and the main feed of the products (products_xml_link).

#### Upload products:
---
The products are also uploaded to the database - description 
> https://support.admitad.com/hc/ru/articles/4405920538897-%D0%A2%D0%BE%D0%B2%D0%B0%D1%80%D0%BD%D1%8B%D0%B9-%D1%84%D0%B8%D0%B4

- Important things in products are title, model, price, images, URL for buying.

#### Schedule upload:
---
- We load the stores and products with a certain periodicity (it is set in the config).

#### Add admin role:
---
- Do admin (with login - logins for login just stored in the database - managing them is not included in the test task) - in the admin edit list of categories (actually name and picture).

#### Rest service:
---
- We make a rest service to get the stores from our database. Paged. And do a search - it returns the found products (search by model and name) from our database. The results are returned page by page.
- And rest to get categories.

### Solution
| Task | Solution |
|----------------|----------------|
| [Authentication on the server](#Authentication-on-the-server)  |[click](https://github.com/Vaixle/talkme-shop-api/blob/main/src/main/java/com/vaixle/talkme/repository/impl/AdmitadCredentialRepositoryImpl.java)  |
| [Requesting shops](#Requesting-shops) | [click](https://github.com/Vaixle/talkme-shop-api/blob/main/src/main/java/com/vaixle/talkme/service/impl/ShopServiceImpl.java) |
| [Upload products](#Upload-products) | [click](https://github.com/Vaixle/talkme-shop-api/blob/main/src/main/java/com/vaixle/talkme/service/impl/ProductServiceImpl.java) |
| [Schedule upload](#Schedule-upload) | [click](https://github.com/Vaixle/talkme-shop-api/blob/main/src/main/java/com/vaixle/talkme/configuration/ScheduleConfiguration.java) |
| [Add admin role](#Add-admin-role) | [click](https://github.com/Vaixle/talkme-shop-api/blob/main/src/main/java/com/vaixle/talkme/configuration/SecurityConfig.java) |
| [Rest service](#Rest-service) | [click](https://github.com/Vaixle/talkme-shop-api/tree/main/src/main/java/com/vaixle/talkme/controller/rest) |

#### API
---

| **HTTP METHOD** |**PATH** |**ROLE**|**QUERY PARAMETRS** |**REQUEST BODY** |**RESPONSE BODY** |*DESCRIPTION** |
|----------------|----------------|----------------|----------------|----------------|----------------|----------------|
|**GET**|`/api/shops`|any|`page` {**required**}</span> - return result page <br> `size` {**required**} - return size of page|none|[click](#get-/api/shops) |Getting list of shops|
|**POST**|`/api/shops/edit`|admin|none|[click](#post-/api/shops/edit)|none| Editing shop name and image|
|**GET**|`/api/products`|any|`search` {**required**} - words for search <br>`field` {**required**} - filter for search *avalible values* ***name*** or ***model***<br>`page` {**required**} - return result page <br>`size` {**required**} - return size of page|none|[click](#get-/api/products)|Getting list of products by name or model|

##### GET /api/shops

> Response body
```
[
    {
        "id": 251,
        "name": "Fornex Hosting",
        "image": "https://cdn.admitad-connect.com/campaign/images/2020/10/16/251-ddd08a99b3e03533.png",
        "categories": [
            {
                "id": 122,
                "name": "Программы и IT-сервисы",
                "language": "ru"
            },
            {
                "id": 18,
                "name": "Интернет-услуги",
                "language": "ru"
            },
            {
                "id": 206,
                "name": "Онлайн для B2B",
                "language": "ru"
            }
        ],
        "gotolink": "https://ad.admitad.com/g/9553369e590a06b3f87424ebb742f6/",
        "products_xml_link": null,
        "actions_detail": [
            {
                "tariffs": [
                    {
                        "id": 11,
                        "name": "Оплаченный заказ - default",
                        "rates": [
                            {
                                "id": 13807,
                                "size": 70.0,
                                "country": null,
                                "tariff_id": null,
                                "price_s": 0.0,
                                "date_s": "2013-01-01",
                                "is_percentage": true
                            }
                        ],
                        "action_id": 11
                    }
                ],
                "id": 11,
                "name": "Оплаченный заказ",
                "type": "sale",
                "hold_size": 0.0
            }
        ]
    }
]

```

##### POST /api/shops/edit

> Request body
```
{
    "id":"251",
    "name":"new",
    "image":"new"
}
```

##### GET /api/products

> Response body
```
[
    {
        "id": 258902,
        "name": "Battlefield 1. Революция (PS4) (GameReplay)",
        "model": "Electronic Arts",
        "price": 1699.0,
        "image": "https://www.gamepark.ru",
        "goToLink": "https://aflink.ru/g/af8ef42a170a06b3f874e8b31ead25/?f_id=15855&ulp=https%3A%2F%2Fwww.gamepark.ru%2Fused%2Fgames%2FBattlefield1TherevolutionPS4GameReplay%2F&i=5"
    }
]
```

