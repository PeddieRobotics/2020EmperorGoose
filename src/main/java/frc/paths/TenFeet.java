package frc.paths;

import com.team319.trajectory.Path;

public class TenFeet extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,33.4980,-5.8000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,-3.1416},
				{0.0200,33.4940,-5.8000,0.0060,0.1999,4.9957,-0.2172,0.0060,0.2000,5.0000,0.0000,0.0060,0.2001,5.0043,0.2172,-3.1416},
				{0.0200,33.4880,-5.8000,0.0120,0.2997,4.9897,-0.2979,0.0120,0.3000,5.0000,0.0000,0.0120,0.3003,5.0103,0.2979,-3.1416},
				{0.0200,33.4800,-5.8000,0.0200,0.3993,4.9800,-0.4860,0.0200,0.4000,5.0000,0.0000,0.0200,0.4007,5.0200,0.4860,-3.1416},
				{0.0200,33.4700,-5.8000,0.0300,0.4986,4.9671,-0.6451,0.0300,0.5000,5.0000,0.0000,0.0300,0.5014,5.0329,0.6451,-3.1416},
				{0.0200,33.4580,-5.8000,0.0419,0.5977,4.9510,-0.8016,0.0420,0.6000,5.0000,0.0000,0.0421,0.6023,5.0490,0.8016,-3.1415},
				{0.0200,33.4440,-5.8000,0.0558,0.6963,4.9319,-0.9552,0.0560,0.7000,5.0000,0.0000,0.0562,0.7037,5.0681,0.9552,-3.1415},
				{0.0200,33.4280,-5.8000,0.0717,0.7945,4.9098,-1.1053,0.0720,0.8000,5.0000,0.0000,0.0723,0.8055,5.0902,1.1053,-3.1414},
				{0.0200,33.4100,-5.8000,0.0896,0.8922,4.8848,-1.2513,0.0900,0.9000,5.0000,0.0000,0.0904,0.9078,5.1152,1.2513,-3.1412},
				{0.0200,33.3900,-5.8000,0.1094,0.9893,4.8569,-1.3931,0.1100,1.0000,5.0000,0.0000,0.1106,1.0107,5.1431,1.3931,-3.1410},
				{0.0200,33.3680,-5.8000,0.1311,1.0859,4.8263,-1.5301,0.1320,1.1000,5.0000,0.0000,0.1329,1.1141,5.1737,1.5301,-3.1408},
				{0.0200,33.3440,-5.8001,0.1547,1.1817,4.7931,-1.6621,0.1560,1.2000,5.0000,0.0000,0.1573,1.2183,5.2069,1.6621,-3.1405},
				{0.0200,33.3180,-5.8001,0.1802,1.2769,4.7573,-1.7890,0.1820,1.3000,5.0000,0.0000,0.1838,1.3231,5.2427,1.7889,-3.1401},
				{0.0200,33.2900,-5.8001,0.2077,1.3713,4.7191,-1.9105,0.2100,1.4000,5.0000,0.0000,0.2123,1.4287,5.2809,1.9104,-3.1396},
				{0.0200,33.2600,-5.8002,0.2370,1.4648,4.6786,-2.0265,0.2400,1.5000,5.0000,0.0000,0.2430,1.5352,5.3214,2.0265,-3.1390},
				{0.0200,33.2280,-5.8003,0.2681,1.5575,4.6358,-2.1372,0.2720,1.6000,5.0000,0.0000,0.2759,1.6425,5.3642,2.1372,-3.1383},
				{0.0200,33.1940,-5.8004,0.3011,1.6494,4.5910,-2.2424,0.3060,1.7000,5.0000,0.0000,0.3109,1.7506,5.4090,2.2423,-3.1375},
				{0.0200,33.1580,-5.8006,0.3359,1.7402,4.5442,-2.3422,0.3420,1.8000,5.0000,0.0000,0.3481,1.8598,5.4558,2.3421,-3.1365},
				{0.0200,33.1200,-5.8008,0.3725,1.8302,4.4954,-2.4367,0.3800,1.9000,5.0000,0.0000,0.3875,1.9698,5.5046,2.4367,-3.1353},
				{0.0200,33.0800,-5.8011,0.4109,1.9191,4.4449,-2.5261,0.4200,2.0000,5.0000,0.0000,0.4291,2.0809,5.5551,2.5260,-3.1339},
				{0.0200,33.0380,-5.8014,0.4510,2.0069,4.3927,-2.6104,0.4620,2.1000,5.0000,0.0000,0.4730,2.1931,5.6073,2.6103,-3.1324},
				{0.0200,32.9940,-5.8019,0.4929,2.0937,4.3389,-2.6897,0.5060,2.2000,5.0000,0.0000,0.5191,2.3063,5.6611,2.6896,-3.1306},
				{0.0200,32.9480,-5.8024,0.5365,2.1794,4.2836,-2.7642,0.5520,2.3000,5.0000,0.0000,0.5675,2.4206,5.7164,2.7641,-3.1286},
				{0.0200,32.9000,-5.8031,0.5818,2.2639,4.2269,-2.8338,0.6000,2.4000,5.0000,0.0000,0.6182,2.5361,5.7731,2.8337,-3.1263},
				{0.0200,32.8500,-5.8039,0.6287,2.3473,4.1690,-2.8985,0.6500,2.5000,5.0000,0.0000,0.6713,2.6527,5.8310,2.8983,-3.1237},
				{0.0200,32.7980,-5.8049,0.6773,2.4295,4.1098,-2.9581,0.7020,2.6000,5.0000,0.0000,0.7267,2.7705,5.8902,2.9580,-3.1208},
				{0.0200,32.7440,-5.8062,0.7275,2.5105,4.0495,-3.0125,0.7560,2.7000,5.0000,0.0000,0.7845,2.8895,5.9504,3.0122,-3.1177},
				{0.0200,32.6881,-5.8076,0.7793,2.5902,3.9883,-3.0610,0.8120,2.8000,5.0000,0.0000,0.8447,3.0098,6.0116,3.0607,-3.1141},
				{0.0200,32.6301,-5.8093,0.8327,2.6688,3.9263,-3.1031,0.8700,2.9000,5.0000,0.0000,0.9073,3.1312,6.0737,3.1028,-3.1102},
				{0.0200,32.5701,-5.8113,0.8876,2.7460,3.8635,-3.1380,0.9300,3.0000,5.0000,0.0000,0.9724,3.2540,6.1364,3.1376,-3.1060},
				{0.0200,32.5082,-5.8137,0.9441,2.8220,3.8002,-3.1645,0.9920,3.1000,5.0000,0.0000,1.0399,3.3780,6.1997,3.1641,-3.1013},
				{0.0200,32.4442,-5.8164,1.0020,2.8968,3.7366,-3.1813,1.0560,3.2000,5.0000,0.0000,1.1100,3.5032,6.2633,3.1807,-3.0962},
				{0.0200,32.3783,-5.8196,1.0614,2.9702,3.6729,-3.1864,1.1220,3.3000,5.0000,0.0000,1.1826,3.6298,6.3271,3.1859,-3.0907},
				{0.0200,32.3104,-5.8232,1.1222,3.0424,3.6093,-3.1780,1.1900,3.4000,5.0000,0.0000,1.2578,3.7576,6.3906,3.1773,-3.0847},
				{0.0200,32.2405,-5.8274,1.1845,3.1133,3.5462,-3.1534,1.2600,3.5000,5.0000,0.0000,1.3355,3.8867,6.4537,3.1527,-3.0782},
				{0.0200,32.1687,-5.8323,1.2482,3.1830,3.4840,-3.1097,1.3320,3.6000,5.0000,0.0000,1.4158,4.0170,6.5158,3.1089,-3.0711},
				{0.0200,32.0949,-5.8377,1.3132,3.2515,3.4232,-3.0434,1.4060,3.7000,5.0000,0.0000,1.4988,4.1485,6.5767,3.0425,-3.0636},
				{0.0200,32.0191,-5.8440,1.3796,3.3188,3.3642,-2.9506,1.4820,3.8000,5.0000,0.0000,1.5844,4.2812,6.6357,2.9497,-3.0555},
				{0.0200,31.9415,-5.8510,1.4473,3.3849,3.3076,-2.8270,1.5600,3.9000,5.0000,0.0000,1.6727,4.4151,6.6922,2.8258,-3.0469},
				{0.0200,31.8619,-5.8589,1.5163,3.4500,3.2543,-2.6676,1.6400,4.0000,5.0000,0.0000,1.7637,4.5500,6.7455,2.6664,-3.0376},
				{0.0200,31.7803,-5.8678,1.5866,3.5141,3.2049,-2.4673,1.7220,4.1000,5.0000,0.0000,1.8574,4.6859,6.7948,2.4660,-3.0278},
				{0.0200,31.6969,-5.8778,1.6581,3.5773,3.1605,-2.2205,1.8060,4.2000,5.0000,0.0000,1.9539,4.8227,6.8392,2.2191,-3.0173},
				{0.0200,31.6117,-5.8890,1.7309,3.6397,3.1221,-1.9215,1.8920,4.3000,5.0000,0.0000,2.0531,4.9602,6.8776,1.9201,-3.0062},
				{0.0200,31.5245,-5.9013,1.8049,3.7016,3.0908,-1.5646,1.9800,4.4000,5.0000,0.0000,2.1551,5.0984,6.9089,1.5631,-2.9945},
				{0.0200,31.4356,-5.9151,1.8802,3.7629,3.0679,-1.1443,2.0700,4.5000,5.0000,0.0000,2.2598,5.2370,6.9317,1.1428,-2.9821},
				{0.0200,31.3449,-5.9303,1.9567,3.8240,3.0548,-0.6558,2.1620,4.6000,5.0000,0.0000,2.3673,5.3759,6.9448,0.6542,-2.9690},
				{0.0200,31.2524,-5.9471,2.0344,3.8851,3.0529,-0.0950,2.2560,4.7000,5.0000,0.0000,2.4776,5.5149,6.9467,0.0935,-2.9553},
				{0.0200,31.1582,-5.9655,2.1133,3.9463,3.0637,0.5406,2.3520,4.8000,5.0000,0.0000,2.5907,5.6536,6.9359,-0.5421,-2.9410},
				{0.0200,31.0623,-5.9857,2.1935,4.0081,3.0887,1.2517,2.4500,4.9000,5.0000,0.0000,2.7065,5.7918,6.9108,-1.2531,-2.9260},
				{0.0200,30.9648,-6.0079,2.2749,4.0707,3.1295,2.0369,2.5500,5.0000,5.0000,0.0000,2.8251,5.9292,6.8700,-2.0381,-2.9104},
				{0.0200,30.8657,-6.0321,2.3576,4.1345,3.1873,2.8917,2.6520,5.1000,5.0000,0.0000,2.9464,6.0654,6.8122,-2.8926,-2.8942},
				{0.0200,30.7651,-6.0584,2.4416,4.1997,3.2635,3.8083,2.7560,5.2000,5.0000,0.0000,3.0704,6.2002,6.7360,-3.8090,-2.8774},
				{0.0200,30.6630,-6.0870,2.5269,4.2669,3.3590,4.7757,2.8620,5.3000,5.0000,0.0000,3.1971,6.3330,6.6405,-4.7760,-2.8600},
				{0.0200,30.5595,-6.1179,2.6136,4.3364,3.4746,5.7787,2.9700,5.4000,5.0000,0.0000,3.3264,6.4635,6.5249,-5.7786,-2.8421},
				{0.0200,30.4547,-6.1513,2.7018,4.4086,3.6105,6.7988,3.0800,5.5000,5.0000,0.0000,3.4582,6.5912,6.3889,-6.7982,-2.8238},
				{0.0200,30.3486,-6.1873,2.7915,4.4839,3.7668,7.8139,3.1920,5.6000,5.0000,0.0000,3.5925,6.7159,6.2327,-7.8128,-2.8050},
				{0.0200,30.2414,-6.2260,2.8827,4.5628,3.9428,8.7996,3.3060,5.7000,5.0000,0.0000,3.7292,6.8370,6.0567,-8.7980,-2.7859},
				{0.0200,30.1331,-6.2674,2.9756,4.6455,4.1374,9.7297,3.4220,5.8000,5.0000,0.0000,3.8683,6.9543,5.8622,-9.7274,-2.7665},
				{0.0200,30.0237,-6.3117,3.0703,4.7325,4.3489,10.5776,3.5400,5.9000,5.0000,0.0000,4.0097,7.0673,5.6507,-10.5749,-2.7469},
				{0.0200,29.9134,-6.3590,3.1668,4.8240,4.5753,11.3182,3.6600,6.0000,5.0000,0.0000,4.1532,7.1758,5.4244,-11.3149,-2.7271},
				{0.0200,29.8022,-6.4092,3.2652,4.9203,4.8139,11.9289,3.7820,6.1000,5.0000,0.0000,4.2988,7.2795,5.1859,-11.9251,-2.7073},
				{0.0200,29.6903,-6.4625,3.3656,5.0215,5.0617,12.3913,3.9060,6.2000,5.0000,0.0000,4.4463,7.3783,4.9381,-12.3872,-2.6875},
				{0.0200,29.5776,-6.5189,3.4682,5.1279,5.3156,12.6929,4.0320,6.3000,5.0000,0.0000,4.5958,7.4719,4.6844,-12.6885,-2.6678},
				{0.0200,29.4643,-6.5784,3.5729,5.2393,5.5721,12.8276,4.1600,6.4000,5.0000,0.0000,4.7470,7.5605,4.4279,-12.8230,-2.6483},
				{0.0200,29.3504,-6.6411,3.6801,5.3559,5.8281,12.7965,4.2900,6.5000,5.0000,0.0000,4.8999,7.6439,4.1721,-12.7918,-2.6291},
				{0.0200,29.2359,-6.7069,3.7896,5.4775,6.0802,12.6076,4.4220,6.6000,5.0000,0.0000,5.0543,7.7223,3.9200,-12.6030,-2.6102},
				{0.0200,29.1211,-6.7758,3.9017,5.6040,6.3257,12.2757,4.5560,6.7000,5.0000,0.0000,5.2102,7.7958,3.6746,-12.2712,-2.5918},
				{0.0200,29.0057,-6.8479,4.0164,5.7352,6.5621,11.8209,4.6920,6.8000,5.0000,0.0000,5.3675,7.8646,3.4383,-11.8168,-2.5739},
				{0.0200,28.8900,-6.9232,4.1338,5.8710,6.7875,11.2679,4.8300,6.9000,5.0000,0.0000,5.5261,7.9289,3.2130,-11.2641,-2.5566},
				{0.0200,28.7740,-7.0014,4.2540,6.0110,7.0004,10.6438,4.9700,7.0000,5.0000,0.0000,5.6859,7.9889,3.0002,-10.6405,-2.5400},
				{0.0200,28.6576,-7.0827,4.3771,6.1550,7.1999,9.9770,5.1120,7.1000,5.0000,0.0000,5.8468,8.0449,2.8007,-9.9742,-2.5241},
				{0.0200,28.5408,-7.1670,4.5032,6.3027,7.3858,9.2955,5.2560,7.2000,5.0000,0.0000,6.0087,8.0972,2.6148,-9.2933,-2.5090},
				{0.0200,28.4237,-7.2542,4.6323,6.4539,7.5583,8.6260,5.4020,7.3000,5.0000,0.0000,6.1716,8.1460,2.4423,-8.6244,-2.4948},
				{0.0200,28.3062,-7.3442,4.7644,6.6082,7.7182,7.9923,5.5500,7.4000,5.0000,0.0000,6.3355,8.1917,2.2825,-7.9913,-2.4815},
				{0.0200,28.1883,-7.4369,4.8997,6.7656,7.8665,7.4153,5.7000,7.5000,5.0000,0.0000,6.5002,8.2343,2.1342,-7.4149,-2.4691},
				{0.0200,28.0699,-7.5323,5.0383,6.9257,8.0047,6.9120,5.8520,7.6000,5.0000,0.0000,6.6656,8.2743,1.9960,-6.9123,-2.4578},
				{0.0200,27.9510,-7.6302,5.1800,7.0883,8.1347,6.4961,6.0060,7.7000,5.0000,0.0000,6.8319,8.3116,1.8660,-6.4969,-2.4475},
				{0.0200,27.8316,-7.7305,5.3251,7.2535,8.2582,6.1773,6.1620,7.8000,5.0000,0.0000,6.9988,8.3464,1.7424,-6.1787,-2.4383},
				{0.0200,27.7115,-7.8332,5.4735,7.4211,8.3775,5.9623,6.3200,7.9000,5.0000,0.0000,7.1664,8.3789,1.6232,-5.9643,-2.4303},
				{0.0200,27.5907,-7.9381,5.6253,7.5909,8.4945,5.8544,6.4800,8.0000,5.0000,0.0000,7.3346,8.4090,1.5060,-5.8569,-2.4234},
				{0.0200,27.4690,-8.0450,5.7806,7.7632,8.6116,5.8542,6.6420,8.1000,5.0000,0.0000,7.5033,8.4368,1.3889,-5.8574,-2.4178},
				{0.0200,27.3464,-8.1539,5.9394,7.9378,8.7308,5.9600,6.8060,8.2000,5.0000,0.0000,7.6725,8.4622,1.2696,-5.9637,-2.4134},
				{0.0200,27.2227,-8.2646,6.1016,8.1149,8.8542,6.1670,6.9720,8.3000,5.0000,0.0000,7.8422,8.4851,1.1462,-6.1715,-2.4102},
				{0.0200,27.0977,-8.3769,6.2675,8.2946,8.9835,6.4684,7.1400,8.4000,5.0000,0.0000,8.0124,8.5054,1.0167,-6.4736,-2.4085},
				{0.0200,26.9714,-8.4907,6.4371,8.4770,9.1206,6.8543,7.3100,8.5000,5.0000,0.0000,8.1828,8.5230,0.8795,-6.8603,-2.4081},
				{0.0200,26.8436,-8.6058,6.6103,8.6623,9.2668,7.3112,7.4820,8.6000,5.0000,0.0000,8.3536,8.5377,0.7331,-7.3181,-2.4091},
				{0.0200,26.7171,-8.7194,6.7833,8.6463,-0.7997,-503.3252,7.6520,8.5000,-5.0000,0.0000,8.5206,8.3537,-9.2005,-496.6818,-2.4116},
				{0.0200,26.5917,-8.8312,6.9558,8.6276,-0.9349,-6.7609,7.8200,8.4000,-5.0000,0.0000,8.6841,8.1724,-9.0654,6.7547,-2.4154},
				{0.0200,26.4673,-8.9411,7.1279,8.6064,-1.0627,-6.3927,7.9860,8.3000,-5.0000,0.0000,8.8440,7.9936,-8.9377,6.3874,-2.4206},
				{0.0200,26.3438,-9.0490,7.2996,8.5827,-1.1852,-6.1216,8.1500,8.2000,-5.0000,0.0000,9.0003,7.8173,-8.8153,6.1170,-2.4270},
				{0.0200,26.2210,-9.1547,7.4707,8.5566,-1.3043,-5.9575,8.3120,8.1000,-5.0000,0.0000,9.1532,7.6434,-8.6963,5.9536,-2.4347},
				{0.0200,26.0989,-9.2581,7.6413,8.5281,-1.4225,-5.9075,8.4720,8.0000,-5.0000,0.0000,9.3026,7.4718,-8.5782,5.9042,-2.4435},
				{0.0200,25.9774,-9.3590,7.8112,8.4973,-1.5420,-5.9758,8.6300,7.9000,-5.0000,0.0000,9.4487,7.3027,-8.4587,5.9732,-2.4536},
				{0.0200,25.8563,-9.4574,7.9805,8.4640,-1.6653,-6.1640,8.7860,7.8000,-5.0000,0.0000,9.5914,7.1359,-8.3355,6.1620,-2.4647},
				{0.0200,25.7357,-9.5532,8.1491,8.4281,-1.7947,-6.4705,8.9400,7.7000,-5.0000,0.0000,9.7308,6.9718,-8.2061,6.4692,-2.4770},
				{0.0200,25.6155,-9.6461,8.3169,8.3894,-1.9325,-6.8904,9.0920,7.6000,-5.0000,0.0000,9.8670,6.8105,-8.0683,6.8898,-2.4902},
				{0.0200,25.4955,-9.7362,8.4838,8.3478,-2.0808,-7.4152,9.2420,7.5000,-5.0000,0.0000,10.0001,6.6521,-7.9200,7.4152,-2.5045},
				{0.0200,25.3759,-9.8234,8.6499,8.3030,-2.2414,-8.0320,9.3900,7.4000,-5.0000,0.0000,10.1300,6.4969,-7.7593,8.0327,-2.5197},
				{0.0200,25.2566,-9.9075,8.8150,8.2547,-2.4159,-8.7237,9.5360,7.3000,-5.0000,0.0000,10.2569,6.3452,-7.5848,8.7251,-2.5357},
				{0.0200,25.1375,-9.9885,8.9790,8.2026,-2.6053,-9.4687,9.6800,7.2000,-5.0000,0.0000,10.3809,6.1973,-7.3954,9.4708,-2.5526},
				{0.0200,25.0188,-10.0663,9.1419,8.1464,-2.8101,-10.2414,9.8220,7.1000,-5.0000,0.0000,10.5019,6.0535,-7.1905,10.2442,-2.5702},
				{0.0200,24.9003,-10.1410,9.3037,8.0858,-3.0303,-11.0124,9.9620,7.0000,-5.0000,0.0000,10.6202,5.9141,-6.9702,11.0158,-2.5884},
				{0.0200,24.7823,-10.2124,9.4641,8.0204,-3.2653,-11.7499,10.1000,6.9000,-5.0000,0.0000,10.7358,5.7794,-6.7351,11.7539,-2.6072},
				{0.0200,24.6646,-10.2805,9.6231,7.9502,-3.5138,-12.4208,10.2360,6.8000,-5.0000,0.0000,10.8488,5.6496,-6.4866,12.4253,-2.6266},
				{0.0200,24.5473,-10.3454,9.7806,7.8747,-3.7736,-12.9926,10.3700,6.7000,-5.0000,0.0000,10.9593,5.5251,-6.2267,12.9975,-2.6463},
				{0.0200,24.4305,-10.4070,9.9364,7.7939,-4.0423,-13.4350,10.5020,6.6000,-5.0000,0.0000,11.0674,5.4059,-5.9579,13.4402,-2.6664},
				{0.0200,24.3143,-10.4653,10.0906,7.7075,-4.3168,-13.7223,10.6320,6.5000,-5.0000,0.0000,11.1733,5.2923,-5.6833,13.7277,-2.6867},
				{0.0200,24.1988,-10.5203,10.2429,7.6156,-4.5934,-13.8346,10.7600,6.4000,-5.0000,0.0000,11.2769,5.1841,-5.4065,13.8399,-2.7071},
				{0.0200,24.0840,-10.5722,10.3933,7.5183,-4.8686,-13.7595,10.8860,6.3000,-5.0000,0.0000,11.3786,5.0815,-5.1312,13.7647,-2.7276},
				{0.0200,23.9699,-10.6209,10.5416,7.4155,-5.1385,-13.4931,11.0100,6.2000,-5.0000,0.0000,11.4783,4.9843,-4.8613,13.4980,-2.7480},
				{0.0200,23.8568,-10.6666,10.6877,7.3075,-5.3993,-13.0399,11.1320,6.1000,-5.0000,0.0000,11.5761,4.8923,-4.6004,13.0443,-2.7683},
				{0.0200,23.7446,-10.7092,10.8316,7.1946,-5.6475,-12.4126,11.2520,6.0000,-5.0000,0.0000,11.6722,4.8052,-4.3521,12.4165,-2.7884},
				{0.0200,23.6335,-10.7489,10.9732,7.0770,-5.8802,-11.6310,11.3700,5.9000,-5.0000,0.0000,11.7667,4.7228,-4.1194,11.6343,-2.8082},
				{0.0200,23.5236,-10.7858,11.1123,6.9551,-6.0946,-10.7205,11.4860,5.8000,-5.0000,0.0000,11.8596,4.6447,-3.9049,10.7232,-2.8276},
				{0.0200,23.4148,-10.8200,11.2488,6.8293,-6.2888,-9.7102,11.6000,5.7000,-5.0000,0.0000,11.9510,4.5705,-3.7107,9.7122,-2.8466},
				{0.0200,23.3073,-10.8515,11.3828,6.7001,-6.4614,-8.6310,11.7120,5.6000,-5.0000,0.0000,12.0410,4.4998,-3.5380,8.6324,-2.8651},
				{0.0200,23.2013,-10.8806,11.5142,6.5678,-6.6117,-7.5136,11.8220,5.5000,-5.0000,0.0000,12.1296,4.4320,-3.3877,7.5144,-2.8830},
				{0.0200,23.0966,-10.9073,11.6429,6.4330,-6.7394,-6.3872,11.9300,5.4000,-5.0000,0.0000,12.2169,4.3668,-3.2600,6.3874,-2.9004},
				{0.0200,22.9935,-10.9318,11.7688,6.2961,-6.8450,-5.2776,12.0360,5.3000,-5.0000,0.0000,12.3030,4.3037,-3.1544,5.2773,-2.9171},
				{0.0200,22.8919,-10.9541,11.8919,6.1576,-6.9291,-4.2071,12.1400,5.2000,-5.0000,0.0000,12.3879,4.2423,-3.0703,4.2063,-2.9332},
				{0.0200,22.7919,-10.9744,12.0123,6.0177,-6.9930,-3.1934,12.2420,5.1000,-5.0000,0.0000,12.4715,4.1822,-3.0065,3.1923,-2.9486},
				{0.0200,22.6937,-10.9929,12.1298,5.8769,-7.0380,-2.2497,12.3420,5.0000,-5.0000,0.0000,12.5540,4.1230,-2.9615,2.2483,-2.9634},
				{0.0200,22.5971,-11.0096,12.2445,5.7356,-7.0657,-1.3850,12.4400,4.9000,-5.0000,0.0000,12.6352,4.0643,-2.9338,1.3835,-2.9774},
				{0.0200,22.5023,-11.0246,12.3564,5.5941,-7.0778,-0.6044,12.5360,4.8000,-5.0000,0.0000,12.7154,4.0059,-2.9218,0.6027,-2.9908},
				{0.0200,22.4093,-11.0382,12.4655,5.4526,-7.0759,0.0906,12.6300,4.7000,-5.0000,0.0000,12.7943,3.9474,-2.9236,-0.0924,-3.0034},
				{0.0200,22.3181,-11.0503,12.5717,5.3113,-7.0619,0.7010,12.7220,4.6000,-5.0000,0.0000,12.8721,3.8886,-2.9377,-0.7028,-3.0154},
				{0.0200,22.2287,-11.0611,12.6751,5.1706,-7.0373,1.2302,12.8120,4.5000,-5.0000,0.0000,12.9487,3.8294,-2.9623,-1.2319,-3.0267},
				{0.0200,22.1412,-11.0707,12.7757,5.0305,-7.0037,1.6828,12.9000,4.4000,-5.0000,0.0000,13.0241,3.7695,-2.9960,-1.6846,-3.0373},
				{0.0200,22.0557,-11.0793,12.8736,4.8913,-6.9624,2.0651,12.9860,4.3000,-5.0000,0.0000,13.0982,3.7087,-3.0373,-2.0667,-3.0472},
				{0.0200,21.9720,-11.0868,12.9686,4.7530,-6.9147,2.3833,13.0700,4.2000,-5.0000,0.0000,13.1712,3.6470,-3.0850,-2.3849,-3.0565},
				{0.0200,21.8903,-11.0934,13.0609,4.6157,-6.8618,2.6443,13.1520,4.1000,-5.0000,0.0000,13.2429,3.5843,-3.1380,-2.6458,-3.0651},
				{0.0200,21.8105,-11.0992,13.1505,4.4796,-6.8047,2.8549,13.2320,4.0000,-5.0000,0.0000,13.3133,3.5203,-3.1951,-2.8562,-3.0732},
				{0.0200,21.7327,-11.1042,13.2374,4.3447,-6.7443,3.0214,13.3100,3.9000,-5.0000,0.0000,13.3824,3.4552,-3.2555,-3.0227,-3.0807},
				{0.0200,21.6568,-11.1086,13.3216,4.2111,-6.6813,3.1500,13.3860,3.8000,-5.0000,0.0000,13.4501,3.3889,-3.3186,-3.1512,-3.0876},
				{0.0200,21.5829,-11.1123,13.4032,4.0788,-6.6164,3.2463,13.4600,3.7000,-5.0000,0.0000,13.5166,3.3212,-3.3835,-3.2473,-3.0940},
				{0.0200,21.5109,-11.1156,13.4822,3.9478,-6.5501,3.3152,13.5320,3.6000,-5.0000,0.0000,13.5816,3.2522,-3.4498,-3.3162,-3.0998},
				{0.0200,21.4410,-11.1183,13.5585,3.8181,-6.4828,3.3613,13.6020,3.5000,-5.0000,0.0000,13.6453,3.1819,-3.5171,-3.3621,-3.1052},
				{0.0200,21.3730,-11.1206,13.6323,3.6898,-6.4151,3.3883,13.6700,3.4000,-5.0000,0.0000,13.7075,3.1102,-3.5849,-3.3890,-3.1100},
				{0.0200,21.3071,-11.1225,13.7036,3.5629,-6.3471,3.3997,13.7360,3.3000,-5.0000,0.0000,13.7682,3.0371,-3.6529,-3.4003,-3.1144},
				{0.0200,21.2431,-11.1241,13.7723,3.4373,-6.2791,3.3981,13.8000,3.2000,-5.0000,0.0000,13.8275,2.9627,-3.7208,-3.3987,-3.1184},
				{0.0200,21.1811,-11.1255,13.8386,3.3131,-6.2114,3.3860,13.8620,3.1000,-5.0000,0.0000,13.8852,2.8869,-3.7886,-3.3865,-3.1220},
				{0.0200,21.1211,-11.1265,13.9024,3.1902,-6.1441,3.3651,13.9220,3.0000,-5.0000,0.0000,13.9414,2.8098,-3.8559,-3.3656,-3.1252},
				{0.0200,21.0631,-11.1274,13.9638,3.0687,-6.0773,3.3371,13.9800,2.9000,-5.0000,0.0000,13.9960,2.7313,-3.9226,-3.3374,-3.1280},
				{0.0200,21.0071,-11.1281,14.0227,2.9484,-6.0113,3.3029,14.0360,2.8000,-5.0000,0.0000,14.0490,2.6516,-3.9887,-3.3032,-3.1305},
				{0.0200,20.9531,-11.1286,14.0793,2.8295,-5.9460,3.2635,14.0900,2.7000,-5.0000,0.0000,14.1005,2.5705,-4.0540,-3.2638,-3.1327},
				{0.0200,20.9011,-11.1291,14.1336,2.7119,-5.8816,3.2194,14.1420,2.6000,-5.0000,0.0000,14.1502,2.4881,-4.1184,-3.2196,-3.1346},
				{0.0200,20.8511,-11.1294,14.1855,2.5955,-5.8182,3.1709,14.1920,2.5000,-5.0000,0.0000,14.1983,2.4045,-4.1818,-3.1711,-3.1362},
				{0.0200,20.8031,-11.1296,14.2351,2.4804,-5.7558,3.1182,14.2400,2.4000,-5.0000,0.0000,14.2447,2.3196,-4.2441,-3.1184,-3.1376},
				{0.0200,20.7571,-11.1297,14.2824,2.3665,-5.6946,3.0613,14.2860,2.3000,-5.0000,0.0000,14.2894,2.2335,-4.3054,-3.0614,-3.1387},
				{0.0200,20.7131,-11.1299,14.3275,2.2538,-5.6346,3.0000,14.3300,2.2000,-5.0000,0.0000,14.3323,2.1462,-4.3654,-3.0001,-3.1396},
				{0.0200,20.6711,-11.1299,14.3703,2.1423,-5.5759,2.9342,14.3720,2.1000,-5.0000,0.0000,14.3734,2.0577,-4.4241,-2.9343,-3.1403},
				{0.0200,20.6311,-11.1300,14.4110,2.0319,-5.5187,2.8635,14.4120,2.0000,-5.0000,0.0000,14.4128,1.9681,-4.4813,-2.8636,-3.1408},
				{0.0200,20.5931,-11.1300,14.4494,1.9227,-5.4629,2.7877,14.4500,1.9000,-5.0000,0.0000,14.4504,1.8773,-4.5371,-2.7877,-3.1412},
				{0.0200,20.5571,-11.1300,14.4857,1.8145,-5.4088,2.7063,14.4860,1.8000,-5.0000,0.0000,14.4861,1.7855,-4.5912,-2.7063,-3.1414},
				{0.0200,20.5231,-11.1300,14.5199,1.7074,-5.3564,2.6191,14.5200,1.7000,-5.0000,0.0000,14.5199,1.6926,-4.6436,-2.6191,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,1.1577,-27.4817,-1106.2631,14.5431,1.6000,-5.0000,0.0000,14.5430,1.1548,-26.8913,-1112.3857,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,-57.8859,-1520.2139,14.5431,1.5000,-5.0000,0.0000,14.5430,0.0000,-57.7411,-1542.4886,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,2894.2972,14.5431,1.4000,-5.0000,0.0000,14.5430,0.0000,0.0000,2887.0541,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,1.3000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,1.2000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,1.1000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,1.0000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.9000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.8000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.7000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.6000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.5000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.4000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.3000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.2000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,0.1000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},
				{0.0200,20.5000,-11.1300,14.5430,0.0000,0.0000,0.0000,14.5431,-0.0000,-5.0000,0.0000,14.5430,0.0000,0.0000,0.0000,-3.1416},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}