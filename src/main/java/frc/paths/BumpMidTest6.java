package frc.paths;

import com.team319.trajectory.Path;

public class BumpMidTest6 extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,20.0020,-7.0000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.0000},
				{0.0200,20.0060,-7.0000,0.0060,0.1998,4.9902,-0.4902,0.0060,0.2000,5.0000,0.0000,0.0060,0.2002,5.0098,0.4902,0.0000},
				{0.0200,20.0120,-7.0000,0.0120,0.2993,4.9768,-0.6700,0.0120,0.3000,5.0000,0.0000,0.0120,0.3007,5.0232,0.6700,0.0000},
				{0.0200,20.0200,-7.0000,0.0200,0.3984,4.9550,-1.0881,0.0200,0.4000,5.0000,0.0000,0.0200,0.4016,5.0450,1.0881,0.0000},
				{0.0200,20.0300,-7.0000,0.0299,0.4970,4.9264,-1.4341,0.0300,0.5000,5.0000,0.0000,0.0301,0.5030,5.0736,1.4341,0.0001},
				{0.0200,20.0420,-7.0000,0.0418,0.5948,4.8910,-1.7661,0.0420,0.6000,5.0000,0.0000,0.0422,0.6052,5.1090,1.7661,0.0002},
				{0.0200,20.0560,-7.0000,0.0556,0.6918,4.8494,-2.0806,0.0560,0.7000,5.0000,0.0000,0.0564,0.7082,5.1506,2.0806,0.0003},
				{0.0200,20.0720,-7.0000,0.0714,0.7878,4.8019,-2.3746,0.0720,0.8000,5.0000,0.0000,0.0726,0.8122,5.1981,2.3746,0.0005},
				{0.0200,20.0900,-7.0000,0.0890,0.8828,4.7490,-2.6449,0.0900,0.9000,5.0000,0.0000,0.0910,0.9172,5.2510,2.6449,0.0008},
				{0.0200,20.1100,-7.0000,0.1086,0.9766,4.6913,-2.8887,0.1100,1.0000,5.0000,0.0000,0.1114,1.0234,5.3087,2.8887,0.0012},
				{0.0200,20.1320,-6.9999,0.1300,1.0692,4.6292,-3.1034,0.1320,1.1000,5.0000,0.0000,0.1340,1.1308,5.3708,3.1034,0.0017},
				{0.0200,20.1560,-6.9999,0.1532,1.1605,4.5635,-3.2863,0.1560,1.2000,5.0000,0.0000,0.1588,1.2395,5.4365,3.2863,0.0024},
				{0.0200,20.1820,-6.9998,0.1782,1.2504,4.4948,-3.4352,0.1820,1.3000,5.0000,0.0000,0.1858,1.3496,5.5052,3.4352,0.0032},
				{0.0200,20.2100,-6.9997,0.2049,1.3388,4.4238,-3.5478,0.2100,1.4000,5.0000,0.0000,0.2151,1.4612,5.5762,3.5477,0.0042},
				{0.0200,20.2400,-6.9996,0.2335,1.4259,4.3514,-3.6219,0.2400,1.5000,5.0000,0.0000,0.2465,1.5741,5.6486,3.6219,0.0055},
				{0.0200,20.2720,-6.9994,0.2637,1.5114,4.2782,-3.6558,0.2720,1.6000,5.0000,0.0000,0.2803,1.6886,5.7217,3.6557,0.0070},
				{0.0200,20.3060,-6.9991,0.2956,1.5955,4.2053,-3.6474,0.3060,1.7000,5.0000,0.0000,0.3164,1.8045,5.7947,3.6473,0.0087},
				{0.0200,20.3420,-6.9987,0.3292,1.6782,4.1334,-3.5949,0.3420,1.8000,5.0000,0.0000,0.3548,1.9218,5.8666,3.5948,0.0108},
				{0.0200,20.3800,-6.9983,0.3644,1.7595,4.0635,-3.4965,0.3800,1.9000,5.0000,0.0000,0.3956,2.0405,5.9365,3.4964,0.0131},
				{0.0200,20.4200,-6.9977,0.4011,1.8394,3.9965,-3.3506,0.4200,2.0000,5.0000,0.0000,0.4389,2.1606,6.0035,3.3504,0.0158},
				{0.0200,20.4620,-6.9970,0.4395,1.9181,3.9334,-3.1552,0.4620,2.1000,5.0000,0.0000,0.4845,2.2819,6.0666,3.1550,0.0189},
				{0.0200,20.5060,-6.9961,0.4794,1.9956,3.8752,-2.9087,0.5060,2.2000,5.0000,0.0000,0.5326,2.4044,6.1248,2.9084,0.0223},
				{0.0200,20.5520,-6.9950,0.5209,2.0720,3.8230,-2.6094,0.5520,2.3000,5.0000,0.0000,0.5831,2.5280,6.1770,2.6091,0.0262},
				{0.0200,20.5999,-6.9936,0.5638,2.1476,3.7779,-2.2558,0.6000,2.4000,5.0000,0.0000,0.6362,2.6524,6.2221,2.2554,0.0304},
				{0.0200,20.6499,-6.9920,0.6083,2.2224,3.7410,-1.8464,0.6500,2.5000,5.0000,0.0000,0.6917,2.7776,6.2590,1.8460,0.0351},
				{0.0200,20.7019,-6.9900,0.6542,2.2967,3.7133,-1.3801,0.7020,2.6000,5.0000,0.0000,0.7498,2.9033,6.2866,1.3797,0.0402},
				{0.0200,20.7558,-6.9877,0.7016,2.3706,3.6962,-0.8562,0.7560,2.7000,5.0000,0.0000,0.8104,3.0294,6.3037,0.8558,0.0457},
				{0.0200,20.8118,-6.9850,0.7505,2.4444,3.6907,-0.2747,0.8120,2.8000,5.0000,0.0000,0.8735,3.1556,6.3092,0.2742,0.0517},
				{0.0200,20.8697,-6.9818,0.8009,2.5184,3.6980,0.3639,0.8700,2.9000,5.0000,0.0000,0.9391,3.2816,6.3019,-0.3644,0.0581},
				{0.0200,20.9296,-6.9781,0.8527,2.5928,3.7192,1.0580,0.9300,3.0000,5.0000,0.0000,1.0073,3.4072,6.2807,-1.0584,0.0649},
				{0.0200,20.9914,-6.9738,0.9061,2.6679,3.7553,1.8047,0.9920,3.1000,5.0000,0.0000,1.0779,3.5321,6.2446,-1.8050,0.0722},
				{0.0200,21.0552,-6.9690,0.9610,2.7440,3.8073,2.5999,1.0560,3.2000,5.0000,0.0000,1.1510,3.6560,6.1926,-2.6002,0.0799},
				{0.0200,21.1210,-6.9635,1.0174,2.8215,3.8760,3.4378,1.1220,3.3000,5.0000,0.0000,1.2266,3.7784,6.1239,-3.4380,0.0879},
				{0.0200,21.1887,-6.9572,1.0754,2.9008,3.9622,4.3112,1.1900,3.4000,5.0000,0.0000,1.3046,3.8992,6.0377,-4.3113,0.0963},
				{0.0200,21.2584,-6.9502,1.1350,2.9821,4.0665,5.2108,1.2600,3.5000,5.0000,0.0000,1.3850,4.0179,5.9334,-5.2108,0.1050},
				{0.0200,21.3299,-6.9423,1.1964,3.0659,4.1890,6.1260,1.3320,3.6000,5.0000,0.0000,1.4676,4.1341,5.8109,-6.1258,0.1140},
				{0.0200,21.4034,-6.9335,1.2594,3.1525,4.3299,7.0444,1.4060,3.7000,5.0000,0.0000,1.5526,4.2475,5.6700,-7.0441,0.1232},
				{0.0200,21.4788,-6.9239,1.3243,3.2423,4.4889,7.9526,1.4820,3.8000,5.0000,0.0000,1.6397,4.3577,5.5110,-7.9520,0.1326},
				{0.0200,21.5560,-6.9132,1.3910,3.3356,4.6656,8.8360,1.5600,3.9000,5.0000,0.0000,1.7290,4.4644,5.3343,-8.8353,0.1420},
				{0.0200,21.6352,-6.9015,1.4596,3.4328,4.8592,9.6801,1.6400,4.0000,5.0000,0.0000,1.8204,4.5672,5.1407,-9.6791,0.1516},
				{0.0200,21.7162,-6.8887,1.5303,3.5341,5.0686,10.4701,1.7220,4.1000,5.0000,0.0000,1.9137,4.6658,4.9313,-10.4690,0.1611},
				{0.0200,21.7990,-6.8748,1.6031,3.6400,5.2925,11.1924,1.8060,4.2000,5.0000,0.0000,2.0089,4.7600,4.7075,-11.1911,0.1705},
				{0.0200,21.8837,-6.8598,1.6781,3.7506,5.5292,11.8346,1.8920,4.3000,5.0000,0.0000,2.1059,4.8494,4.4708,-11.8333,0.1797},
				{0.0200,21.9702,-6.8437,1.7554,3.8661,5.7769,12.3864,1.9800,4.4000,5.0000,0.0000,2.2046,4.9339,4.2231,-12.3849,0.1887},
				{0.0200,22.0586,-6.8265,1.8352,3.9868,6.0337,12.8395,2.0700,4.5000,5.0000,0.0000,2.3048,5.0132,3.9664,-12.8380,0.1973},
				{0.0200,22.1487,-6.8080,1.9174,4.1127,6.2975,13.1882,2.1620,4.6000,5.0000,0.0000,2.4066,5.0872,3.7026,-13.1868,0.2055},
				{0.0200,22.2406,-6.7885,2.0023,4.2441,6.5660,13.4292,2.2560,4.7000,5.0000,0.0000,2.5097,5.1559,3.4341,-13.4279,0.2132},
				{0.0200,22.3344,-6.7679,2.0899,4.3808,6.8373,13.5609,2.3520,4.8000,5.0000,0.0000,2.6141,5.2192,3.1629,-13.5599,0.2202},
				{0.0200,22.4300,-6.7461,2.1804,4.5230,7.1089,13.5834,2.4500,4.9000,5.0000,0.0000,2.7196,5.2770,2.8912,-13.5826,0.2266},
				{0.0200,22.5273,-6.7234,2.2738,4.6706,7.3789,13.4969,2.5500,5.0000,5.0000,0.0000,2.8262,5.3294,2.6213,-13.4965,0.2321},
				{0.0200,22.6265,-6.6997,2.3703,4.8235,7.6449,13.3009,2.6520,5.1000,5.0000,0.0000,2.9337,5.3765,2.3553,-13.3010,0.2367},
				{0.0200,22.7276,-6.6751,2.4699,4.9815,7.9047,12.9928,2.7560,5.2000,5.0000,0.0000,3.0421,5.4184,2.0954,-12.9934,0.2404},
				{0.0200,22.8305,-6.6497,2.5728,5.1447,8.1561,12.5661,2.8620,5.3000,5.0000,0.0000,3.1512,5.4553,1.8441,-12.5674,0.2430},
				{0.0200,22.9353,-6.6236,2.6790,5.3126,8.3963,12.0094,2.9700,5.4000,5.0000,0.0000,3.2609,5.4874,1.6038,-12.0114,0.2445},
				{0.0200,23.0420,-6.5970,2.7887,5.4850,8.6223,11.3041,3.0800,5.5000,5.0000,0.0000,3.3712,5.5150,1.3777,-11.3069,0.2448},
				{0.0200,23.1468,-6.5709,2.8979,5.4581,-1.3459,-498.4134,3.1880,5.4000,-5.0000,0.0000,3.4781,5.3419,-8.6541,-501.5899,0.2438},
				{0.0200,23.2497,-6.5454,3.0064,5.4269,-1.5635,-10.8781,3.2940,5.3000,-5.0000,0.0000,3.5815,5.1731,-8.4366,10.8752,0.2416},
				{0.0200,23.3507,-6.5206,3.1143,5.3909,-1.7959,-11.6195,3.3980,5.2000,-5.0000,0.0000,3.6817,5.0091,-8.2042,11.6173,0.2384},
				{0.0200,23.4499,-6.4968,3.2213,5.3501,-2.0400,-12.2057,3.5000,5.1000,-5.0000,0.0000,3.7787,4.8499,-7.9602,12.2042,0.2342},
				{0.0200,23.5472,-6.4738,3.3273,5.3043,-2.2931,-12.6577,3.6000,5.0000,-5.0000,0.0000,3.8726,4.6957,-7.7070,12.6569,0.2291},
				{0.0200,23.6427,-6.4518,3.4324,5.2532,-2.5529,-12.9896,3.6980,4.9000,-5.0000,0.0000,3.9636,4.5468,-7.4472,12.9894,0.2232},
				{0.0200,23.7364,-6.4309,3.5363,5.1969,-2.8171,-13.2097,3.7940,4.8000,-5.0000,0.0000,4.0516,4.4031,-7.1830,13.2099,0.2165},
				{0.0200,23.8283,-6.4110,3.6391,5.1352,-3.0836,-13.3221,3.8880,4.7000,-5.0000,0.0000,4.1369,4.2648,-6.9166,13.3227,0.2092},
				{0.0200,23.9184,-6.3922,3.7404,5.0682,-3.3501,-13.3283,3.9800,4.6000,-5.0000,0.0000,4.2196,4.1318,-6.6500,13.3292,0.2013},
				{0.0200,24.0066,-6.3746,3.8403,4.9959,-3.6147,-13.2286,4.0700,4.5000,-5.0000,0.0000,4.2997,4.0041,-6.3854,13.2298,0.1930},
				{0.0200,24.0931,-6.3581,3.9387,4.9184,-3.8752,-13.0233,4.1580,4.4000,-5.0000,0.0000,4.3773,3.8816,-6.1249,13.0246,0.1843},
				{0.0200,24.1777,-6.3427,4.0354,4.8358,-4.1294,-12.7134,4.2440,4.3000,-5.0000,0.0000,4.4526,3.7642,-5.8706,12.7148,0.1753},
				{0.0200,24.2604,-6.3285,4.1304,4.7483,-4.3755,-12.3017,4.3280,4.2000,-5.0000,0.0000,4.5256,3.6517,-5.6246,12.3031,0.1661},
				{0.0200,24.3414,-6.3153,4.2235,4.6561,-4.6113,-11.7930,4.4100,4.1000,-5.0000,0.0000,4.5965,3.5439,-5.3887,11.7943,0.1567},
				{0.0200,24.4205,-6.3032,4.3147,4.5594,-4.8352,-11.1944,4.4900,4.0000,-5.0000,0.0000,4.6653,3.4406,-5.1648,11.1957,0.1473},
				{0.0200,24.4977,-6.2921,4.4039,4.4585,-5.0455,-10.5153,4.5680,3.9000,-5.0000,0.0000,4.7321,3.3415,-4.9544,10.5164,0.1379},
				{0.0200,24.5730,-6.2820,4.4909,4.3536,-5.2409,-9.7668,4.6440,3.8000,-5.0000,0.0000,4.7970,3.2463,-4.7591,9.7678,0.1286},
				{0.0200,24.6464,-6.2728,4.5758,4.2452,-5.4201,-8.9617,4.7180,3.7000,-5.0000,0.0000,4.8601,3.1547,-4.5798,8.9625,0.1195},
				{0.0200,24.7179,-6.2646,4.6585,4.1336,-5.5824,-8.1137,4.7900,3.6000,-5.0000,0.0000,4.9215,3.0664,-4.4175,8.1143,0.1105},
				{0.0200,24.7876,-6.2571,4.7389,4.0190,-5.7271,-7.2370,4.8600,3.5000,-5.0000,0.0000,4.9811,2.9809,-4.2728,7.2374,0.1018},
				{0.0200,24.8552,-6.2505,4.8169,3.9020,-5.8540,-6.3454,4.9280,3.4000,-5.0000,0.0000,5.0390,2.8980,-4.1459,6.3457,0.0933},
				{0.0200,24.9210,-6.2446,4.8926,3.7827,-5.9631,-5.4525,4.9940,3.3000,-5.0000,0.0000,5.0954,2.8173,-4.0368,5.4526,0.0852},
				{0.0200,24.9848,-6.2394,4.9658,3.6616,-6.0545,-4.5705,5.0580,3.2000,-5.0000,0.0000,5.1502,2.7384,-3.9454,4.5705,0.0775},
				{0.0200,25.0466,-6.2349,5.0366,3.5390,-6.1287,-3.7104,5.1200,3.1000,-5.0000,0.0000,5.2034,2.6609,-3.8712,3.7102,0.0701},
				{0.0200,25.1065,-6.2309,5.1049,3.4153,-6.1863,-2.8816,5.1800,3.0000,-5.0000,0.0000,5.2551,2.5847,-3.8136,2.8813,0.0631},
				{0.0200,25.1643,-6.2274,5.1707,3.2908,-6.2282,-2.0919,5.2380,2.9000,-5.0000,0.0000,5.3053,2.5092,-3.7717,2.0916,0.0565},
				{0.0200,25.2203,-6.2244,5.2340,3.1656,-6.2551,-1.3475,5.2940,2.8000,-5.0000,0.0000,5.3539,2.4343,-3.7448,1.3471,0.0504},
				{0.0200,25.2742,-6.2219,5.2948,3.0403,-6.2682,-0.6531,5.3480,2.7000,-5.0000,0.0000,5.4011,2.3597,-3.7317,0.6527,0.0447},
				{0.0200,25.3262,-6.2197,5.3531,2.9149,-6.2684,-0.0120,5.4000,2.6000,-5.0000,0.0000,5.4468,2.2851,-3.7315,0.0116,0.0394},
				{0.0200,25.3761,-6.2178,5.4089,2.7898,-6.2569,0.5738,5.4500,2.5000,-5.0000,0.0000,5.4910,2.2102,-3.7430,-0.5742,0.0345},
				{0.0200,25.4241,-6.2163,5.4622,2.6651,-6.2349,1.1031,5.4980,2.4000,-5.0000,0.0000,5.5337,2.1349,-3.7651,-1.1035,0.0300},
				{0.0200,25.4701,-6.2150,5.5131,2.5410,-6.2034,1.5759,5.5440,2.3000,-5.0000,0.0000,5.5749,2.0590,-3.7966,-1.5763,0.0260},
				{0.0200,25.5141,-6.2139,5.5614,2.4177,-6.1635,1.9924,5.5880,2.2000,-5.0000,0.0000,5.6146,1.9823,-3.8365,-1.9928,0.0223},
				{0.0200,25.5561,-6.2131,5.6073,2.2954,-6.1164,2.3537,5.6300,2.1000,-5.0000,0.0000,5.6527,1.9046,-3.8835,-2.3540,0.0191},
				{0.0200,25.5961,-6.2124,5.6508,2.1742,-6.0632,2.6609,5.6700,2.0000,-5.0000,0.0000,5.6892,1.8258,-3.9368,-2.6612,0.0161},
				{0.0200,25.6341,-6.2118,5.6919,2.0541,-6.0049,2.9155,5.7080,1.9000,-5.0000,0.0000,5.7241,1.7459,-3.9951,-2.9158,0.0135},
				{0.0200,25.6700,-6.2114,5.7306,1.9352,-5.9425,3.1192,5.7440,1.8000,-5.0000,0.0000,5.7574,1.6648,-4.0575,-3.1194,0.0113},
				{0.0200,25.7040,-6.2110,5.7669,1.8177,-5.8771,3.2737,5.7780,1.7000,-5.0000,0.0000,5.7890,1.5823,-4.1229,-3.2739,0.0093},
				{0.0200,25.7360,-6.2107,5.8010,1.7015,-5.8094,3.3808,5.8100,1.6000,-5.0000,0.0000,5.8190,1.4985,-4.1906,-3.3809,0.0076},
				{0.0200,25.7660,-6.2105,5.8327,1.5867,-5.7406,3.4422,5.8400,1.5000,-5.0000,0.0000,5.8473,1.4133,-4.2594,-3.4423,0.0061},
				{0.0200,25.7940,-6.2104,5.8622,1.4732,-5.6714,3.4599,5.8680,1.4000,-5.0000,0.0000,5.8738,1.3268,-4.3286,-3.4599,0.0049},
				{0.0200,25.8200,-6.2103,5.8894,1.3612,-5.6027,3.4357,5.8940,1.3000,-5.0000,0.0000,5.8986,1.2388,-4.3973,-3.4357,0.0039},
				{0.0200,25.8440,-6.2102,5.9144,1.2505,-5.5353,3.3715,5.9180,1.2000,-5.0000,0.0000,5.9216,1.1495,-4.4647,-3.3716,0.0030},
				{0.0200,25.8660,-6.2101,5.9372,1.1411,-5.4699,3.2695,5.9400,1.1000,-5.0000,0.0000,5.9428,1.0589,-4.5301,-3.2695,0.0023},
				{0.0200,25.8860,-6.2101,5.9579,1.0329,-5.4072,3.1317,5.9600,1.0000,-5.0000,0.0000,5.9621,0.9671,-4.5928,-3.1317,0.0018},
				{0.0200,25.9040,-6.2101,5.9764,0.9260,-5.3480,2.9604,5.9780,0.9000,-5.0000,0.0000,5.9796,0.8740,-4.6520,-2.9604,0.0013},
				{0.0200,25.9200,-6.2100,5.9928,0.8201,-5.2929,2.7580,5.9940,0.8000,-5.0000,0.0000,5.9952,0.7799,-4.7071,-2.7580,0.0010},
				{0.0200,25.9340,-6.2100,6.0071,0.7153,-5.2423,2.5269,6.0080,0.7000,-5.0000,0.0000,6.0089,0.6847,-4.7577,-2.5269,0.0007},
				{0.0200,25.9460,-6.2100,6.0193,0.6113,-5.1969,2.2699,6.0200,0.6000,-5.0000,0.0000,6.0206,0.5887,-4.8031,-2.2700,0.0006},
				{0.0200,25.9560,-6.2100,6.0295,0.5082,-5.1571,1.9899,6.0300,0.5000,-5.0000,0.0000,6.0305,0.4918,-4.8429,-1.9899,0.0004},
				{0.0200,25.9640,-6.2100,6.0376,0.4057,-5.1233,1.6897,6.0380,0.4000,-5.0000,0.0000,6.0384,0.3943,-4.8767,-1.6897,0.0003},
				{0.0200,25.9700,-6.2100,6.0437,0.3038,-5.0959,1.3725,6.0440,0.3000,-5.0000,0.0000,6.0443,0.2962,-4.9041,-1.3725,0.0003},
				{0.0200,25.9740,-6.2100,6.0477,0.2023,-5.0751,1.0416,6.0480,0.2000,-5.0000,0.0000,6.0482,0.1977,-4.9249,-1.0416,0.0002},
				{0.0200,25.9760,-6.2100,6.0498,0.1011,-5.0610,0.7002,6.0500,0.1000,-5.0000,0.0000,6.0502,0.0989,-4.9390,-0.7002,0.0002},
				{0.0200,25.9760,-6.2100,6.0498,0.0000,-5.0540,0.3519,6.0500,-0.0000,-5.0000,0.0000,6.0502,0.0000,-4.9460,-0.3519,0.0002},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}