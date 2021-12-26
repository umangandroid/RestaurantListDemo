package com.umang.restaurantlistdemo.datasource

     //json response string used in unit test to get [Restaurant] list
     const val responseString = "{\n" +
            "\t\"restaurants\": [{\n" +
            "\t\t\"id\": \"1\",\n" +
            "\t\t\"name\": \"Tanoshii Sushi\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 0.0,\n" +
            "\t\t\t\"newest\": 96.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 1190,\n" +
            "\t\t\t\"popularity\": 17.0,\n" +
            "\t\t\t\"averageProductPrice\": 1536,\n" +
            "\t\t\t\"deliveryCosts\": 200,\n" +
            "\t\t\t\"minCost\": 1000\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"2\",\n" +
            "\t\t\"name\": \"Tandoori Express\",\n" +
            "\t\t\"status\": \"closed\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 1.0,\n" +
            "\t\t\t\"newest\": 266.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 2308,\n" +
            "\t\t\t\"popularity\": 123.0,\n" +
            "\t\t\t\"averageProductPrice\": 1146,\n" +
            "\t\t\t\"deliveryCosts\": 150,\n" +
            "\t\t\t\"minCost\": 1300\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"3\",\n" +
            "\t\t\"name\": \"Royal Thai\",\n" +
            "\t\t\"status\": \"order ahead\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 2.0,\n" +
            "\t\t\t\"newest\": 133.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 2639,\n" +
            "\t\t\t\"popularity\": 44.0,\n" +
            "\t\t\t\"averageProductPrice\": 1492,\n" +
            "\t\t\t\"deliveryCosts\": 150,\n" +
            "\t\t\t\"minCost\": 2500\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"4\",\n" +
            "\t\t\"name\": \"Sushi One\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 3.0,\n" +
            "\t\t\t\"newest\": 238.0,\n" +
            "\t\t\t\"ratingAverage\": 4.0,\n" +
            "\t\t\t\"distance\": 1618,\n" +
            "\t\t\t\"popularity\": 23.0,\n" +
            "\t\t\t\"averageProductPrice\": 1285,\n" +
            "\t\t\t\"deliveryCosts\": 0,\n" +
            "\t\t\t\"minCost\": 1200\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"5\",\n" +
            "\t\t\"name\": \"Roti Shop\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 4.0,\n" +
            "\t\t\t\"newest\": 247.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 2308,\n" +
            "\t\t\t\"popularity\": 81.0,\n" +
            "\t\t\t\"averageProductPrice\": 915,\n" +
            "\t\t\t\"deliveryCosts\": 0,\n" +
            "\t\t\t\"minCost\": 2000\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"6\",\n" +
            "\t\t\"name\": \"Aarti 2\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 5.0,\n" +
            "\t\t\t\"newest\": 153.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 1605,\n" +
            "\t\t\t\"popularity\": 44.0,\n" +
            "\t\t\t\"averageProductPrice\": 922,\n" +
            "\t\t\t\"deliveryCosts\": 250,\n" +
            "\t\t\t\"minCost\": 500\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"7\",\n" +
            "\t\t\"name\": \"Pizza Heart\",\n" +
            "\t\t\"status\": \"order ahead\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 6.0,\n" +
            "\t\t\t\"newest\": 118.0,\n" +
            "\t\t\t\"ratingAverage\": 4.0,\n" +
            "\t\t\t\"distance\": 2453,\n" +
            "\t\t\t\"popularity\": 9.0,\n" +
            "\t\t\t\"averageProductPrice\": 1103,\n" +
            "\t\t\t\"deliveryCosts\": 150,\n" +
            "\t\t\t\"minCost\": 1500\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"8\",\n" +
            "\t\t\"name\": \"Mama Mia\",\n" +
            "\t\t\"status\": \"order ahead\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 7.0,\n" +
            "\t\t\t\"newest\": 250.0,\n" +
            "\t\t\t\"ratingAverage\": 4.0,\n" +
            "\t\t\t\"distance\": 1396,\n" +
            "\t\t\t\"popularity\": 6.0,\n" +
            "\t\t\t\"averageProductPrice\": 912,\n" +
            "\t\t\t\"deliveryCosts\": 0,\n" +
            "\t\t\t\"minCost\": 1000\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"9\",\n" +
            "\t\t\"name\": \"Feelfood\",\n" +
            "\t\t\"status\": \"order ahead\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 8.0,\n" +
            "\t\t\t\"newest\": 163.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 2732,\n" +
            "\t\t\t\"popularity\": 31.0,\n" +
            "\t\t\t\"averageProductPrice\": 902,\n" +
            "\t\t\t\"deliveryCosts\": 150,\n" +
            "\t\t\t\"minCost\": 1500\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"10\",\n" +
            "\t\t\"name\": \"Daily Sushi\",\n" +
            "\t\t\"status\": \"closed\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 9.0,\n" +
            "\t\t\t\"newest\": 221.0,\n" +
            "\t\t\t\"ratingAverage\": 4.0,\n" +
            "\t\t\t\"distance\": 1911,\n" +
            "\t\t\t\"popularity\": 6.0,\n" +
            "\t\t\t\"averageProductPrice\": 1327,\n" +
            "\t\t\t\"deliveryCosts\": 200,\n" +
            "\t\t\t\"minCost\": 1000\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"11\",\n" +
            "\t\t\"name\": \"Pamukkale\",\n" +
            "\t\t\"status\": \"closed\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 10.0,\n" +
            "\t\t\t\"newest\": 201.0,\n" +
            "\t\t\t\"ratingAverage\": 4.0,\n" +
            "\t\t\t\"distance\": 2353,\n" +
            "\t\t\t\"popularity\": 25.0,\n" +
            "\t\t\t\"averageProductPrice\": 968,\n" +
            "\t\t\t\"deliveryCosts\": 0,\n" +
            "\t\t\t\"minCost\": 2000\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"12\",\n" +
            "\t\t\"name\": \"Indian Kitchen\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 11.0,\n" +
            "\t\t\t\"newest\": 272.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 2308,\n" +
            "\t\t\t\"popularity\": 5.0,\n" +
            "\t\t\t\"averageProductPrice\": 1189,\n" +
            "\t\t\t\"deliveryCosts\": 150,\n" +
            "\t\t\t\"minCost\": 1300\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"13\",\n" +
            "\t\t\"name\": \"CIRO 1939\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 12.0,\n" +
            "\t\t\t\"newest\": 231.0,\n" +
            "\t\t\t\"ratingAverage\": 4.5,\n" +
            "\t\t\t\"distance\": 3957,\n" +
            "\t\t\t\"popularity\": 79.0,\n" +
            "\t\t\t\"averageProductPrice\": 1762,\n" +
            "\t\t\t\"deliveryCosts\": 99,\n" +
            "\t\t\t\"minCost\": 1300\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"14\",\n" +
            "\t\t\"name\": \"Zenzai Sushi\",\n" +
            "\t\t\"status\": \"closed\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 13.0,\n" +
            "\t\t\t\"newest\": 155.0,\n" +
            "\t\t\t\"ratingAverage\": 4.0,\n" +
            "\t\t\t\"distance\": 2911,\n" +
            "\t\t\t\"popularity\": 36.0,\n" +
            "\t\t\t\"averageProductPrice\": 1579,\n" +
            "\t\t\t\"deliveryCosts\": 0,\n" +
            "\t\t\t\"minCost\": 2000\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"15\",\n" +
            "\t\t\"name\": \"Fes Patisserie\",\n" +
            "\t\t\"status\": \"order ahead\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 14.0,\n" +
            "\t\t\t\"newest\": 77.0,\n" +
            "\t\t\t\"ratingAverage\": 4.0,\n" +
            "\t\t\t\"distance\": 2302,\n" +
            "\t\t\t\"popularity\": 3.0,\n" +
            "\t\t\t\"averageProductPrice\": 1214,\n" +
            "\t\t\t\"deliveryCosts\": 150,\n" +
            "\t\t\t\"minCost\": 1250\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"16\",\n" +
            "\t\t\"name\": \"Yvonne's Vispaleis\",\n" +
            "\t\t\"status\": \"order ahead\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 15.0,\n" +
            "\t\t\t\"newest\": 150.0,\n" +
            "\t\t\t\"ratingAverage\": 5.0,\n" +
            "\t\t\t\"distance\": 2909,\n" +
            "\t\t\t\"popularity\": 3.0,\n" +
            "\t\t\t\"averageProductPrice\": 2557,\n" +
            "\t\t\t\"deliveryCosts\": 150,\n" +
            "\t\t\t\"minCost\": 1750\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"17\",\n" +
            "\t\t\"name\": \"De Amsterdamsche Tram\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 304.0,\n" +
            "\t\t\t\"newest\": 131.0,\n" +
            "\t\t\t\"ratingAverage\": 0.0,\n" +
            "\t\t\t\"distance\": 2792,\n" +
            "\t\t\t\"popularity\": 0.0,\n" +
            "\t\t\t\"averageProductPrice\": 892,\n" +
            "\t\t\t\"deliveryCosts\": 0,\n" +
            "\t\t\t\"minCost\": 0\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"18\",\n" +
            "\t\t\"name\": \"Lale Restaurant & Snackbar\",\n" +
            "\t\t\"status\": \"order ahead\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 305.0,\n" +
            "\t\t\t\"newest\": 73.0,\n" +
            "\t\t\t\"ratingAverage\": 0.0,\n" +
            "\t\t\t\"distance\": 2880,\n" +
            "\t\t\t\"popularity\": 0.0,\n" +
            "\t\t\t\"averageProductPrice\": 838,\n" +
            "\t\t\t\"deliveryCosts\": 0,\n" +
            "\t\t\t\"minCost\": 0\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"19\",\n" +
            "\t\t\"name\": \"Lunchpakketdienst\",\n" +
            "\t\t\"status\": \"open\",\n" +
            "\t\t\"sortingValues\": {\n" +
            "\t\t\t\"bestMatch\": 306.0,\n" +
            "\t\t\t\"newest\": 259.0,\n" +
            "\t\t\t\"ratingAverage\": 3.5,\n" +
            "\t\t\t\"distance\": 14201,\n" +
            "\t\t\t\"popularity\": 0.0,\n" +
            "\t\t\t\"averageProductPrice\": 4465,\n" +
            "\t\t\t\"deliveryCosts\": 500,\n" +
            "\t\t\t\"minCost\": 5000\n" +
            "\t\t}\n" +
            "\t}]\n" +
            "}"
