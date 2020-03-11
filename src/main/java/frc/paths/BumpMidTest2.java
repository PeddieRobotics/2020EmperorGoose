package frc.paths;

import com.team319.trajectory.Path;

public class BumpMidTest2 extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,20.2028,-7.9400,0.0028,0.1400,7.0000,0.0000,0.0028,0.1400,7.0000,0.0000,0.0028,0.1400,7.0000,0.0000,0.0000},
				{0.0200,20.2084,-7.9400,0.0084,0.2798,6.9881,-0.5954,0.0084,0.2800,7.0000,0.0000,0.0084,0.2802,7.0119,0.5954,0.0000},
				{0.0200,20.2168,-7.9400,0.0168,0.4192,6.9718,-0.8161,0.0168,0.4200,7.0000,0.0000,0.0168,0.4208,7.0282,0.8161,0.0000},
				{0.0200,20.2280,-7.9400,0.0279,0.5581,6.9452,-1.3305,0.0280,0.5600,7.0000,0.0000,0.0281,0.5619,7.0548,1.3305,0.0000},
				{0.0200,20.2420,-7.9400,0.0419,0.6963,6.9099,-1.7647,0.0420,0.7000,7.0000,0.0000,0.0421,0.7037,7.0901,1.7647,0.0001},
				{0.0200,20.2588,-7.9400,0.0585,0.8336,6.8660,-2.1924,0.0588,0.8400,7.0000,0.0000,0.0591,0.8464,7.1340,2.1924,0.0002},
				{0.0200,20.2784,-7.9400,0.0779,0.9699,6.8137,-2.6137,0.0784,0.9800,7.0000,0.0000,0.0789,0.9901,7.1863,2.6137,0.0004},
				{0.0200,20.3008,-7.9400,0.1000,1.1050,6.7531,-3.0301,0.1008,1.1200,7.0000,0.0000,0.1016,1.1350,7.2469,3.0301,0.0006},
				{0.0200,20.3260,-7.9400,0.1248,1.2386,6.6843,-3.4442,0.1260,1.2600,7.0000,0.0000,0.1272,1.2814,7.3157,3.4442,0.0010},
				{0.0200,20.3540,-7.9399,0.1522,1.3708,6.6070,-3.8602,0.1540,1.4000,7.0000,0.0000,0.1558,1.4292,7.3929,3.8602,0.0015},
				{0.0200,20.3848,-7.9399,0.1822,1.5012,6.5214,-4.2839,0.1848,1.5400,7.0000,0.0000,0.1874,1.5788,7.4786,4.2839,0.0021},
				{0.0200,20.4184,-7.9398,0.2148,1.6297,6.4269,-4.7230,0.2184,1.6800,7.0000,0.0000,0.2220,1.7303,7.5731,4.7229,0.0030},
				{0.0200,20.4548,-7.9397,0.2500,1.7562,6.3232,-5.1872,0.2548,1.8200,7.0000,0.0000,0.2596,1.8838,7.6768,5.1871,0.0041},
				{0.0200,20.4940,-7.9395,0.2876,1.8804,6.2094,-5.6885,0.2940,1.9600,7.0000,0.0000,0.3004,2.0396,7.7906,5.6884,0.0054},
				{0.0200,20.5360,-7.9392,0.3276,2.0021,6.0846,-6.2419,0.3360,2.1000,7.0000,0.0000,0.3444,2.1979,7.9154,6.2417,0.0070},
				{0.0200,20.5808,-7.9388,0.3700,2.1210,5.9473,-6.8653,0.3808,2.2400,7.0000,0.0000,0.3916,2.3590,8.0527,6.8651,0.0090},
				{0.0200,20.6284,-7.9384,0.4148,2.2369,5.7956,-7.5809,0.4284,2.3800,7.0000,0.0000,0.4420,2.5231,8.2043,7.5805,0.0114},
				{0.0200,20.6788,-7.9377,0.4618,2.3495,5.6273,-8.4155,0.4788,2.5200,7.0000,0.0000,0.4958,2.6905,8.3726,8.4150,0.0143},
				{0.0200,20.7320,-7.9369,0.5109,2.4583,5.4393,-9.4025,0.5320,2.6600,7.0000,0.0000,0.5531,2.8617,8.5607,9.4019,0.0177},
				{0.0200,20.7880,-7.9358,0.5622,2.5628,5.2276,-10.5836,0.5880,2.8000,7.0000,0.0000,0.6138,3.0372,8.7723,10.5828,0.0217},
				{0.0200,20.8468,-7.9344,0.6154,2.6626,4.9874,-12.0111,0.6468,2.9400,7.0000,0.0000,0.6782,3.2174,9.0125,12.0099,0.0264},
				{0.0200,20.9083,-7.9326,0.6706,2.7568,4.7123,-13.7516,0.7084,3.0800,7.0000,0.0000,0.7462,3.4032,9.2875,13.7499,0.0318},
				{0.0200,20.9727,-7.9303,0.7275,2.8447,4.3945,-15.8909,0.7728,3.2200,7.0000,0.0000,0.8181,3.5953,9.6053,15.8890,0.0381},
				{0.0200,21.0398,-7.9275,0.7860,2.9252,4.0237,-18.5414,0.8400,3.3600,7.0000,0.0000,0.8940,3.7948,9.9761,18.5383,0.0454},
				{0.0200,21.1097,-7.9241,0.8459,2.9969,3.5867,-21.8502,0.9100,3.5000,7.0000,0.0000,0.9741,4.0031,10.4130,21.8461,0.0539},
				{0.0200,21.1824,-7.9198,0.9071,3.0583,3.0664,-26.0142,0.9828,3.6400,7.0000,0.0000,1.0585,4.2217,10.9332,26.0088,0.0636},
				{0.0200,21.2578,-7.9146,0.9692,3.1071,2.4404,-31.2989,1.0584,3.7800,7.0000,0.0000,1.1476,4.4529,11.5590,31.2907,0.0749},
				{0.0200,21.3360,-7.9082,1.0320,3.1406,1.6792,-38.0640,1.1368,3.9200,7.0000,0.0000,1.2416,4.6993,12.3201,38.0531,0.0880},
				{0.0200,21.4156,-7.9006,1.0942,3.1097,-1.5497,-161.4445,1.2168,4.0000,7.0000,0.0000,1.3394,4.8903,9.5488,-138.5627,0.1030},
				{0.0200,21.4951,-7.8917,1.1543,3.0019,-5.3888,-191.9521,1.2968,4.0000,7.0000,0.0000,1.4393,4.9980,5.3878,-208.0492,0.1198},
				{0.0200,21.5745,-7.8814,1.2119,2.8800,-6.0950,-35.3115,1.3768,4.0000,7.0000,0.0000,1.5417,5.1199,6.0938,35.2984,0.1386},
				{0.0200,21.6536,-7.8695,1.2667,2.7411,-6.9420,-42.3489,1.4568,4.0000,7.0000,0.0000,1.6469,5.2587,6.9404,42.3320,0.1598},
				{0.0200,21.7324,-7.8559,1.3183,2.5820,-7.9591,-50.8580,1.5368,4.0000,7.0000,0.0000,1.7553,5.4179,7.9571,50.8355,0.1836},
				{0.0200,21.8108,-7.8402,1.3663,2.3983,-9.1814,-61.1134,1.6168,4.0000,7.0000,0.0000,1.8673,5.6014,9.1788,61.0832,0.2105},
				{0.0200,21.8888,-7.8224,1.4100,2.1854,-10.6487,-73.3643,1.6968,4.0000,7.0000,0.0000,1.9836,5.8143,10.6453,73.3235,0.2410},
				{0.0200,21.9662,-7.8019,1.4487,1.9373,-12.4035,-87.7396,1.7768,4.0000,7.0000,0.0000,2.1048,6.0623,12.3990,87.6847,0.2757},
				{0.0200,22.0427,-7.7787,1.4817,1.6476,-14.4846,-104.0553,1.8568,4.0000,7.0000,0.0000,2.2319,6.3519,14.4786,103.9810,0.3152},
				{0.0200,22.1182,-7.7522,1.5079,1.3093,-16.9135,-121.4465,1.9368,4.0000,7.0000,0.0000,2.3657,6.6900,16.9055,121.3467,0.3604},
				{0.0200,22.1923,-7.7221,1.5262,0.9160,-19.6680,-137.7216,2.0168,4.0000,7.0000,0.0000,2.5073,7.0831,19.6573,137.5903,0.4123},
				{0.0200,22.2646,-7.6880,1.5355,0.4633,-22.6347,-148.3361,2.0968,4.0000,7.0000,0.0000,2.6580,7.5356,22.6208,148.1734,0.4717},
				{0.0200,22.3346,-7.6493,1.5364,0.0476,-20.7847,92.4976,2.1768,4.0000,7.0000,0.0000,2.8190,8.0459,25.5184,144.8829,0.5397},
				{0.0200,22.4016,-7.6056,1.5485,0.6042,27.8337,2430.9222,2.2568,4.0000,7.0000,0.0000,2.9910,8.6022,27.8154,114.8451,0.6171},
				{0.0200,22.4648,-7.5566,1.5721,1.1778,28.6776,42.1943,2.3368,4.0000,7.0000,0.0000,3.1745,9.1753,28.6514,41.8002,0.7041},
				{0.0200,22.5233,-7.5020,1.6064,1.7166,26.9405,-86.8538,2.4168,4.0000,7.0000,0.0000,3.3688,9.7135,26.9129,-86.9207,0.8002},
				{0.0200,22.5759,-7.4418,1.6494,2.1491,21.6264,-265.7060,2.4968,4.0000,7.0000,0.0000,3.5717,10.1456,21.6023,-265.5338,0.9036},
				{0.0200,22.6220,-7.3764,1.6974,2.3999,12.5364,-454.4996,2.5768,4.0000,7.0000,0.0000,3.7796,10.3960,12.5216,-454.0325,1.0112},
				{0.0200,22.6607,-7.3065,1.7457,2.4173,0.8721,-583.2166,2.6568,4.0000,7.0000,0.0000,3.9879,10.4134,0.8710,-582.5291,1.1190},
				{0.0200,22.6918,-7.2328,1.7897,2.1983,-10.9523,-591.2215,2.7368,4.0000,7.0000,0.0000,4.1918,10.1946,-10.9393,-590.5187,1.2232},
				{0.0200,22.7153,-7.1564,1.8255,1.7894,-20.4422,-474.4906,2.8168,4.0000,7.0000,0.0000,4.3875,9.7863,-20.4191,-473.9880,1.3205},
				{0.0200,22.7316,-7.0781,1.8508,1.2650,-26.2226,-289.0219,2.8968,4.0000,7.0000,0.0000,4.5727,9.2623,-26.1953,-288.8118,1.4090},
				{0.0200,22.7413,-6.9987,1.8647,0.6980,-28.3491,-106.3239,2.9768,4.0000,7.0000,0.0000,4.7467,8.6959,-28.3226,-106.3632,1.4880},
				{0.0200,22.7451,-6.9188,1.8676,0.1427,-27.7642,29.2433,3.0568,4.0000,7.0000,0.0000,4.9095,8.1410,-27.7423,29.0159,1.5576},
				{0.0200,22.7436,-6.8388,1.8750,0.3693,11.3295,1954.6851,3.1368,4.0000,7.0000,0.0000,5.0621,7.6295,-25.5785,108.1868,1.6186},
				{0.0200,22.7376,-6.7591,1.8915,0.8241,22.7422,570.6349,3.2168,4.0000,7.0000,0.0000,5.2056,7.1749,-22.7279,142.5310,1.6720},
				{0.0200,22.7276,-6.6797,1.9158,1.2196,19.7717,-148.5256,3.2968,4.0000,7.0000,0.0000,5.3412,6.7797,-19.7607,148.3633,1.7187},
				{0.0200,22.7142,-6.6008,1.9470,1.5593,16.9876,-139.2028,3.3768,4.0000,7.0000,0.0000,5.4700,6.4401,-16.9793,139.0679,1.7598},
				{0.0200,22.6977,-6.5226,1.9840,1.8497,14.5184,-123.4635,3.4568,4.0000,7.0000,0.0000,5.5930,6.1499,-14.5121,123.3607,1.7959},
				{0.0200,22.6786,-6.4449,2.0260,2.0976,12.3942,-106.2099,3.5368,4.0000,7.0000,0.0000,5.7110,5.9021,-12.3894,106.1329,1.8279},
				{0.0200,22.6571,-6.3678,2.0722,2.3095,10.5972,-89.8480,3.6168,4.0000,7.0000,0.0000,5.8248,5.6902,-10.5936,89.7909,1.8563},
				{0.0200,22.6336,-6.2913,2.1220,2.4913,9.0900,-75.3604,3.6968,4.0000,7.0000,0.0000,5.9350,5.5085,-9.0873,75.3179,1.8816},
				{0.0200,22.6083,-6.2155,2.1750,2.6479,7.8302,-62.9908,3.7768,4.0000,7.0000,0.0000,6.0420,5.3519,-7.8281,62.9598,1.9044},
				{0.0200,22.5813,-6.1402,2.2306,2.7835,6.7774,-52.6385,3.8568,4.0000,7.0000,0.0000,6.1463,5.2164,-6.7758,52.6147,1.9248},
				{0.0200,22.5529,-6.0654,2.2886,2.9014,5.8961,-44.0645,3.9368,4.0000,7.0000,0.0000,6.2483,5.0985,-5.8948,44.0470,1.9433},
				{0.0200,22.5231,-5.9911,2.3487,3.0045,5.1561,-36.9982,4.0168,4.0000,7.0000,0.0000,6.3482,4.9954,-5.1551,36.9849,1.9600},
				{0.0200,22.4922,-5.9173,2.4106,3.0952,4.5325,-31.1821,4.0968,4.0000,7.0000,0.0000,6.4463,4.9048,-4.5317,31.1713,1.9752},
				{0.0200,22.4602,-5.8440,2.4741,3.1753,4.0047,-26.3895,4.1768,4.0000,7.0000,0.0000,6.5428,4.8247,-4.0041,26.3819,1.9891},
				{0.0200,22.4272,-5.7711,2.5391,3.2464,3.5561,-22.4315,4.2568,4.0000,7.0000,0.0000,6.6379,4.7536,-3.5556,22.4253,2.0017},
				{0.0200,22.3934,-5.6986,2.6053,3.3098,3.1731,-19.1511,4.3368,4.0000,7.0000,0.0000,6.7317,4.6901,-3.1726,19.1461,2.0133},
				{0.0200,22.3587,-5.6265,2.6726,3.3667,2.8446,-16.4214,4.4168,4.0000,7.0000,0.0000,6.8243,4.6332,-2.8443,16.4176,2.0240},
				{0.0200,22.3234,-5.5548,2.7410,3.4180,2.5618,-14.1401,4.4968,4.0000,7.0000,0.0000,6.9160,4.5820,-2.5615,14.1370,2.0338},
				{0.0200,22.2873,-5.4834,2.8103,3.4643,2.3173,-12.2247,4.5768,4.0000,7.0000,0.0000,7.0067,4.5357,-2.3171,12.2222,2.0428},
				{0.0200,22.2506,-5.4123,2.8804,3.5064,2.1052,-10.6089,4.6568,4.0000,7.0000,0.0000,7.0966,4.4936,-2.1050,10.6070,2.0510},
				{0.0200,22.2134,-5.3415,2.9513,3.5448,1.9204,-9.2395,4.7368,4.0000,7.0000,0.0000,7.1857,4.4552,-1.9202,9.2379,2.0587},
				{0.0200,22.1756,-5.2709,3.0229,3.5800,1.7589,-8.0733,4.8168,4.0000,7.0000,0.0000,7.2741,4.4200,-1.7588,8.0719,2.0658},
				{0.0200,22.1374,-5.2007,3.0951,3.6124,1.6174,-7.0753,4.8968,4.0000,7.0000,0.0000,7.3618,4.3876,-1.6173,7.0742,2.0723},
				{0.0200,22.0987,-5.1306,3.1680,3.6422,1.4931,-6.2173,4.9768,4.0000,7.0000,0.0000,7.4490,4.3578,-1.4929,6.2166,2.0783},
				{0.0200,22.0597,-5.0608,3.2414,3.6699,1.3835,-5.4764,5.0568,4.0000,7.0000,0.0000,7.5356,4.3301,-1.3834,5.4756,2.0838},
				{0.0200,22.0202,-4.9912,3.3153,3.6956,1.2869,-4.8333,5.1368,4.0000,7.0000,0.0000,7.6217,4.3044,-1.2868,4.8326,2.0890},
				{0.0200,21.9804,-4.9218,3.3897,3.7196,1.2014,-4.2726,5.2168,4.0000,7.0000,0.0000,7.7073,4.2803,-1.2013,4.2721,2.0937},
				{0.0200,21.9403,-4.8526,3.4645,3.7422,1.1258,-3.7814,5.2968,4.0000,7.0000,0.0000,7.7924,4.2578,-1.1257,3.7810,2.0980},
				{0.0200,21.8999,-4.7835,3.5398,3.7633,1.0588,-3.3490,5.3768,4.0000,7.0000,0.0000,7.8772,4.2367,-1.0588,3.3486,2.1020},
				{0.0200,21.8593,-4.7146,3.6154,3.7833,0.9995,-2.9665,5.4568,4.0000,7.0000,0.0000,7.9615,4.2167,-0.9994,2.9662,2.1056},
				{0.0200,21.8184,-4.6459,3.6915,3.8023,0.9469,-2.6264,5.5368,4.0000,7.0000,0.0000,8.0455,4.1977,-0.9469,2.6261,2.1089},
				{0.0200,21.7773,-4.5772,3.7679,3.8203,0.9005,-2.3224,5.6168,4.0000,7.0000,0.0000,8.1290,4.1797,-0.9005,2.3223,2.1120},
				{0.0200,21.7360,-4.5087,3.8446,3.8375,0.8595,-2.0493,5.6968,4.0000,7.0000,0.0000,8.2123,4.1625,-0.8595,2.0490,2.1147},
				{0.0200,21.6945,-4.4403,3.9217,3.8539,0.8235,-1.8022,5.7768,4.0000,7.0000,0.0000,8.2952,4.1461,-0.8234,1.8021,2.1171},
				{0.0200,21.6529,-4.3720,3.9991,3.8698,0.7919,-1.5776,5.8568,4.0000,7.0000,0.0000,8.3778,4.1302,-0.7919,1.5774,2.1193},
				{0.0200,21.6111,-4.3038,4.0768,3.8851,0.7645,-1.3719,5.9368,4.0000,7.0000,0.0000,8.4601,4.1149,-0.7645,1.3717,2.1213},
				{0.0200,21.5692,-4.2356,4.1548,3.8999,0.7408,-1.1821,6.0168,4.0000,7.0000,0.0000,8.5421,4.1001,-0.7408,1.1820,2.1229},
				{0.0200,21.5272,-4.1676,4.2331,3.9143,0.7207,-1.0059,6.0968,4.0000,7.0000,0.0000,8.6238,4.0857,-0.7207,1.0057,2.1244},
				{0.0200,21.4851,-4.0995,4.3117,3.9284,0.7039,-0.8407,6.1768,4.0000,7.0000,0.0000,8.7053,4.0716,-0.7039,0.8407,2.1256},
				{0.0200,21.4429,-4.0316,4.3905,3.9422,0.6902,-0.6848,6.2568,4.0000,7.0000,0.0000,8.7864,4.0578,-0.6902,0.6846,2.1266},
				{0.0200,21.4006,-3.9636,4.4696,3.9558,0.6795,-0.5359,6.3368,4.0000,7.0000,0.0000,8.8673,4.0442,-0.6795,0.5359,2.1273},
				{0.0200,21.3584,-3.8957,4.5490,3.9692,0.6716,-0.3928,6.4168,4.0000,7.0000,0.0000,8.9479,4.0308,-0.6716,0.3927,2.1278},
				{0.0200,21.3161,-3.8278,4.6287,3.9825,0.6666,-0.2535,6.4968,4.0000,7.0000,0.0000,9.0283,4.0175,-0.6666,0.2535,2.1281},
				{0.0200,21.2738,-3.7599,4.7086,3.9958,0.6642,-0.1167,6.5768,4.0000,7.0000,0.0000,9.1084,4.0042,-0.6642,0.1166,2.1282},
				{0.0200,21.2314,-3.6920,4.7888,4.0091,0.6646,0.0192,6.6568,4.0000,7.0000,0.0000,9.1882,3.9909,-0.6646,-0.0193,2.1280},
				{0.0200,21.1891,-3.6241,4.8692,4.0225,0.6677,0.1556,6.7368,4.0000,7.0000,0.0000,9.2677,3.9775,-0.6677,-0.1557,2.1277},
				{0.0200,21.1469,-3.5562,4.9499,4.0359,0.6736,0.2940,6.8168,4.0000,7.0000,0.0000,9.3470,3.9641,-0.6736,-0.2941,2.1271},
				{0.0200,21.1047,-3.4882,5.0309,4.0496,0.6823,0.4359,6.8968,4.0000,7.0000,0.0000,9.4260,3.9504,-0.6823,-0.4360,2.1262},
				{0.0200,21.0625,-3.4202,5.1122,4.0635,0.6940,0.5829,6.9768,4.0000,7.0000,0.0000,9.5048,3.9365,-0.6940,-0.5830,2.1252},
				{0.0200,21.0204,-3.3522,5.1937,4.0776,0.7087,0.7368,7.0568,4.0000,7.0000,0.0000,9.5832,3.9224,-0.7087,-0.7368,2.1238},
				{0.0200,20.9785,-3.2841,5.2756,4.0922,0.7267,0.8993,7.1368,4.0000,7.0000,0.0000,9.6614,3.9078,-0.7267,-0.8994,2.1223},
				{0.0200,20.9366,-3.2159,5.3577,4.1071,0.7481,1.0726,7.2168,4.0000,7.0000,0.0000,9.7392,3.8929,-0.7482,-1.0727,2.1205},
				{0.0200,20.8949,-3.1477,5.4402,4.1226,0.7733,1.2589,7.2968,4.0000,7.0000,0.0000,9.8168,3.8774,-0.7733,-1.2590,2.1184},
				{0.0200,20.8533,-3.0793,5.5230,4.1386,0.8025,1.4608,7.3768,4.0000,7.0000,0.0000,9.8940,3.8614,-0.8026,-1.4610,2.1161},
				{0.0200,20.8119,-3.0109,5.6061,4.1554,0.8362,1.6813,7.4568,4.0000,7.0000,0.0000,9.9709,3.8446,-0.8362,-1.6815,2.1135},
				{0.0200,20.7707,-2.9423,5.6895,4.1729,0.8746,1.9240,7.5368,4.0000,7.0000,0.0000,10.0474,3.8271,-0.8747,-1.9240,2.1106},
				{0.0200,20.7297,-2.8736,5.7733,4.1912,0.9185,2.1924,7.6168,4.0000,7.0000,0.0000,10.1236,3.8088,-0.9185,-2.1927,2.1074},
				{0.0200,20.6889,-2.8048,5.8576,4.2106,0.9683,2.4916,7.6968,4.0000,7.0000,0.0000,10.1994,3.7894,-0.9684,-2.4919,2.1038},
				{0.0200,20.6484,-2.7358,5.9422,4.2311,1.0249,2.8270,7.7768,4.0000,7.0000,0.0000,10.2748,3.7689,-1.0249,-2.8273,2.1000},
				{0.0200,20.6081,-2.6667,6.0272,4.2529,1.0890,3.2051,7.8568,4.0000,7.0000,0.0000,10.3497,3.7471,-1.0890,-3.2055,2.0957},
				{0.0200,20.5682,-2.5973,6.1128,4.2761,1.1616,3.6338,7.9368,4.0000,7.0000,0.0000,10.4242,3.7239,-1.1617,-3.6341,2.0911},
				{0.0200,20.5286,-2.5278,6.1988,4.3010,1.2441,4.1222,8.0168,4.0000,7.0000,0.0000,10.4982,3.6990,-1.2442,-4.1227,2.0860},
				{0.0200,20.4894,-2.4581,6.2853,4.3277,1.3377,4.6819,8.0968,4.0000,7.0000,0.0000,10.5716,3.6722,-1.3378,-4.6825,2.0805},
				{0.0200,20.4506,-2.3881,6.3725,4.3566,1.4443,5.3267,8.1768,4.0000,7.0000,0.0000,10.6445,3.6434,-1.4444,-5.3273,2.0745},
				{0.0200,20.4122,-2.3180,6.4602,4.3879,1.5657,6.0732,8.2568,4.0000,7.0000,0.0000,10.7167,3.6120,-1.5658,-6.0740,2.0680},
				{0.0200,20.3743,-2.2475,6.5487,4.4220,1.7046,6.9421,8.3368,4.0000,7.0000,0.0000,10.7883,3.5779,-1.7047,-6.9432,2.0609},
				{0.0200,20.3369,-2.1768,6.6379,4.4593,1.8637,7.9592,8.4168,4.0000,7.0000,0.0000,10.8591,3.5407,-1.8639,-7.9604,2.0532},
				{0.0200,20.3001,-2.1058,6.7279,4.5002,2.0469,9.1559,8.4968,4.0000,7.0000,0.0000,10.9291,3.4997,-2.0471,-9.1575,2.0448},
				{0.0200,20.2639,-2.0344,6.8188,4.5454,2.2583,10.5722,8.5768,4.0000,7.0000,0.0000,10.9982,3.4546,-2.2585,-10.5739,2.0356},
				{0.0200,20.2284,-1.9627,6.9107,4.5955,2.5035,12.2573,8.6568,4.0000,7.0000,0.0000,11.0663,3.4045,-2.5037,-12.2599,2.0256},
				{0.0200,20.1936,-1.8907,7.0037,4.6513,2.7890,14.2750,8.7368,4.0000,7.0000,0.0000,11.1332,3.3487,-2.7893,-14.2777,2.0146},
				{0.0200,20.1597,-1.8182,7.0980,4.7137,3.1230,16.7044,8.8168,4.0000,7.0000,0.0000,11.1990,3.2862,-3.1234,-16.7080,2.0026},
				{0.0200,20.1267,-1.7454,7.1937,4.7840,3.5160,19.6475,8.8968,4.0000,7.0000,0.0000,11.2633,3.2159,-3.5165,-19.6526,1.9895},
				{0.0200,20.0947,-1.6720,7.2909,4.8637,3.9807,23.2359,8.9768,4.0000,7.0000,0.0000,11.3260,3.1363,-3.9813,-23.2416,1.9750},
				{0.0200,20.0638,-1.5982,7.3900,4.9543,4.5334,27.6358,9.0568,4.0000,7.0000,0.0000,11.3869,3.0456,-4.5342,-27.6440,1.9589},
				{0.0200,20.0342,-1.5239,7.4912,5.0582,5.1947,33.0644,9.1368,4.0000,7.0000,0.0000,11.4458,2.9417,-5.1957,-33.0747,1.9411},
				{0.0200,20.0059,-1.4491,7.5947,5.1780,5.9907,39.7977,9.2168,4.0000,7.0000,0.0000,11.5022,2.8218,-5.9919,-39.8116,1.9213},
				{0.0200,19.9793,-1.3736,7.7011,5.3171,6.9545,48.1890,9.2968,4.0000,7.0000,0.0000,11.5558,2.6827,-6.9561,-48.2078,1.8992},
				{0.0200,19.9544,-1.2976,7.8107,5.4797,8.1281,58.6818,9.3768,4.0000,7.0000,0.0000,11.6062,2.5201,-8.1302,-58.7069,1.8743},
				{0.0200,19.9315,-1.2209,7.9241,5.6710,9.5644,71.8157,9.4568,4.0000,7.0000,0.0000,11.6528,2.3288,-9.5672,-71.8505,1.8462},
				{0.0200,19.9110,-1.1436,8.0420,5.8975,11.3286,88.2117,9.5368,4.0000,7.0000,0.0000,11.6949,2.1021,-11.3324,-88.2604,1.8143},
				{0.0200,19.8931,-1.0657,8.1654,6.1675,13.4986,108.4967,9.6168,4.0000,7.0000,0.0000,11.7315,1.8320,-13.5037,-108.5642,1.7779},
				{0.0200,19.8782,-0.9871,8.2952,6.4907,16.1604,133.0916,9.6968,4.0000,7.0000,0.0000,11.7617,1.5087,-16.1675,-133.1875,1.7360},
				{0.0200,19.8670,-0.9079,8.4328,6.8786,19.3949,161.7267,9.7768,4.0000,7.0000,0.0000,11.7841,1.1206,-19.4047,-161.8607,1.6876},
				{0.0200,19.8598,-0.8282,8.5797,7.3435,23.2428,192.3920,9.8568,4.0000,7.0000,0.0000,11.7972,0.6555,-23.2562,-192.5775,1.6314},
				{0.0200,19.8575,-0.7483,8.7376,7.8961,27.6297,219.3465,9.9368,4.0000,7.0000,0.0000,11.7992,0.1026,-27.6461,-219.4953,1.5659},
				{0.0200,19.8609,-0.6683,8.9084,8.5406,32.2258,229.8034,10.0168,4.0000,7.0000,0.0000,11.8101,0.5425,21.9999,2482.3017,1.4896},
				{0.0200,19.8708,-0.5890,9.0937,9.2651,36.2254,199.9793,10.0968,4.0000,7.0000,0.0000,11.8355,1.2677,36.2586,712.9349,1.4010},
				{0.0200,19.8882,-0.5109,9.2942,10.0274,38.1174,94.6038,10.1768,4.0000,7.0000,0.0000,11.8761,2.0309,38.1580,94.9708,1.2997},
				{0.0200,19.9139,-0.4352,9.5091,10.7420,35.7279,-119.4790,10.2568,4.0000,7.0000,0.0000,11.9310,2.7463,35.7709,-119.3548,1.1863},
				{0.0200,19.9483,-0.3631,9.7347,11.2828,27.0403,-434.3761,10.3368,4.0000,7.0000,0.0000,11.9968,3.2878,27.0761,-434.7387,1.0637},
				{0.0200,19.9915,-0.2958,9.9652,11.5215,11.9357,-755.2298,10.4168,4.0000,7.0000,0.0000,12.0673,3.5269,11.9524,-756.1857,0.9372},
				{0.0200,20.0427,-0.2344,10.1930,11.3921,-6.4705,-920.3122,10.4968,4.0000,7.0000,0.0000,12.1352,3.3973,-6.4796,-921.6018,0.8128},
				{0.0200,20.1010,-0.1797,10.4116,10.9320,-23.0054,-826.7457,10.5768,4.0000,7.0000,0.0000,12.1940,2.9365,-23.0365,-827.8458,0.6962},
				{0.0200,20.1651,-0.1318,10.6168,10.2581,-33.6952,-534.4899,10.6568,4.0000,7.0000,0.0000,12.2392,2.2618,-33.7372,-535.0318,0.5910},
				{0.0200,20.2335,-0.0904,10.8069,9.5026,-37.7750,-203.9876,10.7368,4.0000,7.0000,0.0000,12.2693,1.5055,-37.8169,-203.9848,0.4984},
				{0.0200,20.3053,-0.0551,10.9822,8.7644,-36.9085,43.3228,10.8168,4.0000,7.0000,0.0000,12.2846,0.7666,-36.9441,43.6374,0.4183},
				{0.0200,20.3794,-0.0252,11.1441,8.0974,-33.3527,177.7909,10.8968,4.0000,7.0000,0.0000,12.2866,0.0990,-33.3781,178.3032,0.3494},
				{0.0200,20.4554,-0.0001,11.2945,7.5206,-28.8382,225.7271,10.9768,4.0000,7.0000,0.0000,12.2962,0.4782,18.9603,2616.9194,0.2902},
				{0.0200,20.5326,0.0208,11.4352,7.0335,-24.3556,224.1284,11.0568,4.0000,7.0000,0.0000,12.3155,0.9656,24.3704,270.5012,0.2392},
				{0.0200,20.6107,0.0380,11.5677,6.6265,-20.3477,200.3939,11.1368,4.0000,7.0000,0.0000,12.3430,1.3728,20.3585,-200.5930,0.1951},
				{0.0200,20.6895,0.0519,11.6935,6.2876,-16.9454,170.1142,11.2168,4.0000,7.0000,0.0000,12.3772,1.7119,16.9532,-170.2626,0.1566},
				{0.0200,20.7687,0.0630,11.8136,6.0050,-14.1319,140.6782,11.2968,4.0000,7.0000,0.0000,12.4171,1.9946,14.1376,-140.7837,0.1229},
				{0.0200,20.8483,0.0716,11.9289,5.7683,-11.8335,114.9198,11.3768,4.0000,7.0000,0.0000,12.4617,2.2314,11.8377,-114.9953,0.0932},
				{0.0200,20.9280,0.0780,12.0403,5.5691,-9.9639,93.4799,11.4568,4.0000,7.0000,0.0000,12.5103,2.4307,9.9670,-93.5332,0.0668},
				{0.0200,21.0079,0.0824,12.1483,5.4002,-8.4424,76.0712,11.5368,4.0000,7.0000,0.0000,12.5623,2.5996,8.4448,-76.1099,0.0433},
				{0.0200,21.0878,0.0850,12.2534,5.2562,-7.2004,62.1012,11.6168,4.0000,7.0000,0.0000,12.6172,2.7437,7.2022,-62.1290,0.0222},
				{0.0200,21.1678,0.0860,12.3561,5.1326,-6.1817,50.9372,11.6968,4.0000,7.0000,0.0000,12.6745,2.8673,6.1831,-50.9581,0.0032},
				{0.0200,21.2478,0.0856,12.4566,5.0257,-5.3414,42.0160,11.7768,4.0000,7.0000,0.0000,12.7340,2.9742,5.3424,-42.0306,-0.0141},
				{0.0200,21.3278,0.0838,12.5553,4.9329,-4.6441,34.8653,11.8568,4.0000,7.0000,0.0000,12.7954,3.0671,4.6449,-34.8772,-0.0298},
				{0.0200,21.4078,0.0808,12.6523,4.8516,-4.0618,29.1110,11.9368,4.0000,7.0000,0.0000,12.8583,3.1483,4.0625,-29.1196,-0.0441},
				{0.0200,21.4876,0.0768,12.7479,4.7802,-3.5727,24.4551,12.0168,4.0000,7.0000,0.0000,12.9227,3.2198,3.5733,-24.4616,-0.0572},
				{0.0200,21.5675,0.0717,12.8422,4.7170,-3.1594,20.6665,12.0968,4.0000,7.0000,0.0000,12.9884,3.2830,3.1598,-20.6716,-0.0692},
				{0.0200,21.6473,0.0657,12.9355,4.6608,-2.8081,17.5651,12.1768,4.0000,7.0000,0.0000,13.0552,3.3391,2.8085,-17.5696,-0.0804},
				{0.0200,21.7270,0.0589,13.0277,4.6107,-2.5079,15.0120,12.2568,4.0000,7.0000,0.0000,13.1230,3.3893,2.5082,-15.0148,-0.0906},
				{0.0200,21.8066,0.0513,13.1190,4.5657,-2.2499,12.8964,12.3368,4.0000,7.0000,0.0000,13.1916,3.4343,2.2502,-12.8989,-0.1001},
				{0.0200,21.8862,0.0429,13.2095,4.5251,-2.0273,11.1338,12.4168,4.0000,7.0000,0.0000,13.2611,3.4749,2.0275,-11.1359,-0.1089},
				{0.0200,21.9657,0.0339,13.2993,4.4884,-1.8341,9.6568,12.4968,4.0000,7.0000,0.0000,13.3314,3.5115,1.8343,-9.6587,-0.1172},
				{0.0200,22.0451,0.0242,13.3884,4.4551,-1.6659,8.4129,12.5768,4.0000,7.0000,0.0000,13.4023,3.5449,1.6660,-8.4137,-0.1248},
				{0.0200,22.1244,0.0140,13.4768,4.4247,-1.5187,7.3584,12.6568,4.0000,7.0000,0.0000,13.4738,3.5752,1.5188,-7.3599,-0.1319},
				{0.0200,22.2037,0.0032,13.5648,4.3969,-1.3895,6.4614,12.7368,4.0000,7.0000,0.0000,13.5458,3.6030,1.3896,-6.4622,-0.1386},
				{0.0200,22.2829,-0.0081,13.6522,4.3714,-1.2756,5.6938,12.8168,4.0000,7.0000,0.0000,13.6184,3.6285,1.2757,-5.6944,-0.1449},
				{0.0200,22.3620,-0.0199,13.7392,4.3479,-1.1749,5.0338,12.8968,4.0000,7.0000,0.0000,13.6914,3.6520,1.1750,-5.0345,-0.1507},
				{0.0200,22.4411,-0.0321,13.8257,4.3262,-1.0856,4.4640,12.9768,4.0000,7.0000,0.0000,13.7649,3.6738,1.0857,-4.4647,-0.1562},
				{0.0200,22.5201,-0.0448,13.9118,4.3061,-1.0062,3.9699,13.0568,4.0000,7.0000,0.0000,13.8388,3.6939,1.0063,-3.9703,-0.1613},
				{0.0200,22.5990,-0.0578,13.9976,4.2874,-0.9354,3.5396,13.1368,4.0000,7.0000,0.0000,13.9131,3.7126,0.9355,-3.5397,-0.1662},
				{0.0200,22.6779,-0.0712,14.0830,4.2699,-0.8722,3.1625,13.2168,4.0000,7.0000,0.0000,13.9877,3.7300,0.8722,-3.1635,-0.1707},
				{0.0200,22.7567,-0.0850,14.1680,4.2536,-0.8155,2.8325,13.2968,4.0000,7.0000,0.0000,14.0626,3.7464,0.8156,-2.8321,-0.1750},
				{0.0200,22.8354,-0.0991,14.2528,4.2383,-0.7647,2.5402,13.3768,4.0000,7.0000,0.0000,14.1378,3.7617,0.7648,-2.5409,-0.1790},
				{0.0200,22.9141,-0.1135,14.3373,4.2240,-0.7191,2.2822,13.4568,4.0000,7.0000,0.0000,14.2133,3.7760,0.7191,-2.2825,-0.1827},
				{0.0200,22.9927,-0.1281,14.4215,4.2104,-0.6780,2.0528,13.5368,4.0000,7.0000,0.0000,14.2891,3.7896,0.6781,-2.0527,-0.1863},
				{0.0200,23.0713,-0.1431,14.5054,4.1976,-0.6411,1.8478,13.6168,4.0000,7.0000,0.0000,14.3652,3.8024,0.6411,-1.8479,-0.1896},
				{0.0200,23.1499,-0.1583,14.5892,4.1854,-0.6078,1.6641,13.6968,4.0000,7.0000,0.0000,14.4415,3.8146,0.6078,-1.6645,-0.1927},
				{0.0200,23.2284,-0.1737,14.6726,4.1739,-0.5778,1.4990,13.7768,4.0000,7.0000,0.0000,14.5180,3.8261,0.5778,-1.4992,-0.1956},
				{0.0200,23.3068,-0.1894,14.7559,4.1629,-0.5508,1.3499,13.8568,4.0000,7.0000,0.0000,14.5947,3.8371,0.5508,-1.3497,-0.1984},
				{0.0200,23.3852,-0.2053,14.8389,4.1523,-0.5265,1.2142,13.9368,4.0000,7.0000,0.0000,14.6717,3.8477,0.5266,-1.2143,-0.2009},
				{0.0200,23.4636,-0.2213,14.9218,4.1422,-0.5047,1.0905,14.0168,4.0000,7.0000,0.0000,14.7488,3.8578,0.5047,-1.0910,-0.2033},
				{0.0200,23.5419,-0.2376,15.0044,4.1325,-0.4852,0.9778,14.0968,4.0000,7.0000,0.0000,14.8262,3.8675,0.4852,-0.9773,-0.2055},
				{0.0200,23.6202,-0.2540,15.0869,4.1232,-0.4677,0.8729,14.1768,4.0000,7.0000,0.0000,14.9037,3.8768,0.4677,-0.8735,-0.2076},
				{0.0200,23.6985,-0.2705,15.1692,4.1141,-0.4522,0.7768,14.2568,4.0000,7.0000,0.0000,14.9814,3.8859,0.4522,-0.7766,-0.2095},
				{0.0200,23.7767,-0.2872,15.2513,4.1054,-0.4384,0.6867,14.3368,4.0000,7.0000,0.0000,15.0593,3.8946,0.4385,-0.6868,-0.2113},
				{0.0200,23.8550,-0.3041,15.3332,4.0968,-0.4264,0.6023,14.4168,4.0000,7.0000,0.0000,15.1374,3.9032,0.4264,-0.6025,-0.2129},
				{0.0200,23.9331,-0.3210,15.4150,4.0885,-0.4159,0.5229,14.4968,4.0000,7.0000,0.0000,15.2156,3.9115,0.4159,-0.5230,-0.2144},
				{0.0200,24.0113,-0.3381,15.4966,4.0804,-0.4070,0.4474,14.5768,4.0000,7.0000,0.0000,15.2940,3.9196,0.4070,-0.4472,-0.2158},
				{0.0200,24.0894,-0.3553,15.5780,4.0724,-0.3995,0.3749,14.6568,4.0000,7.0000,0.0000,15.3726,3.9276,0.3995,-0.3751,-0.2170},
				{0.0200,24.1675,-0.3726,15.6593,4.0645,-0.3934,0.3051,14.7368,4.0000,7.0000,0.0000,15.4513,3.9355,0.3934,-0.3052,-0.2181},
				{0.0200,24.2456,-0.3899,15.7405,4.0567,-0.3886,0.2372,14.8168,4.0000,7.0000,0.0000,15.5301,3.9433,0.3886,-0.2371,-0.2190},
				{0.0200,24.3237,-0.4073,15.8215,4.0490,-0.3852,0.1704,14.8968,4.0000,7.0000,0.0000,15.6092,3.9510,0.3852,-0.1705,-0.2198},
				{0.0200,24.4018,-0.4248,15.9023,4.0414,-0.3831,0.1043,14.9768,4.0000,7.0000,0.0000,15.6883,3.9586,0.3832,-0.1043,-0.2205},
				{0.0200,24.4798,-0.4423,15.9830,4.0337,-0.3824,0.0382,15.0568,4.0000,7.0000,0.0000,15.7677,3.9663,0.3824,-0.0382,-0.2211},
				{0.0200,24.5579,-0.4599,16.0635,4.0261,-0.3830,-0.0285,15.1368,4.0000,7.0000,0.0000,15.8471,3.9739,0.3830,0.0286,-0.2215},
				{0.0200,24.6359,-0.4775,16.1438,4.0184,-0.3849,-0.0966,15.2168,4.0000,7.0000,0.0000,15.9268,3.9816,0.3849,0.0966,-0.2219},
				{0.0200,24.7140,-0.4951,16.2241,4.0106,-0.3882,-0.1667,15.2968,4.0000,7.0000,0.0000,16.0066,3.9894,0.3882,0.1666,-0.2220},
				{0.0200,24.7920,-0.5127,16.3041,4.0029,-0.3839,0.2139,15.3768,4.0000,7.0000,0.0000,16.0865,3.9971,0.3839,-0.2139,-0.2221},
				{0.0200,24.8700,-0.5303,16.3842,4.0047,0.0867,23.5335,15.4568,4.0000,7.0000,0.0000,16.1664,3.9953,-0.0867,-23.5335,-0.2222},
				{0.0200,24.9481,-0.5480,16.4644,4.0113,0.3318,12.2555,15.5368,4.0000,7.0000,0.0000,16.2462,3.9887,-0.3318,-12.2555,-0.2224},
				{0.0200,25.0261,-0.5656,16.5448,4.0173,0.3007,-1.5578,15.6168,4.0000,7.0000,0.0000,16.3258,3.9827,-0.3007,1.5578,-0.2226},
				{0.0200,25.1041,-0.5833,16.6252,4.0227,0.2705,-1.5092,15.6968,4.0000,7.0000,0.0000,16.4054,3.9773,-0.2705,1.5092,-0.2230},
				{0.0200,25.1821,-0.6010,16.7058,4.0275,0.2413,-1.4607,15.7768,4.0000,7.0000,0.0000,16.4848,3.9725,-0.2413,1.4607,-0.2235},
				{0.0200,25.2601,-0.6188,16.7864,4.0318,0.2130,-1.4122,15.8568,4.0000,7.0000,0.0000,16.5642,3.9682,-0.2130,1.4122,-0.2240},
				{0.0200,25.3381,-0.6366,16.8671,4.0355,0.1858,-1.3638,15.9368,4.0000,7.0000,0.0000,16.6435,3.9645,-0.1858,1.3638,-0.2246},
				{0.0200,25.4161,-0.6544,16.9479,4.0387,0.1595,-1.3154,16.0168,4.0000,7.0000,0.0000,16.7227,3.9613,-0.1595,1.3154,-0.2253},
				{0.0200,25.4941,-0.6723,17.0287,4.0414,0.1341,-1.2670,16.0968,4.0000,7.0000,0.0000,16.8019,3.9586,-0.1341,1.2670,-0.2260},
				{0.0200,25.5721,-0.6903,17.1096,4.0436,0.1097,-1.2186,16.1768,4.0000,7.0000,0.0000,16.8810,3.9564,-0.1097,1.2186,-0.2267},
				{0.0200,25.6500,-0.7083,17.1905,4.0453,0.0863,-1.1702,16.2568,4.0000,7.0000,0.0000,16.9601,3.9547,-0.0863,1.1702,-0.2275},
				{0.0200,25.7279,-0.7263,17.2714,4.0466,0.0639,-1.1218,16.3368,4.0000,7.0000,0.0000,17.0392,3.9534,-0.0639,1.1218,-0.2282},
				{0.0200,25.8059,-0.7445,17.3524,4.0474,0.0424,-1.0734,16.4168,4.0000,7.0000,0.0000,17.1182,3.9526,-0.0424,1.0734,-0.2290},
				{0.0200,25.8838,-0.7627,17.4333,4.0479,0.0219,-1.0249,16.4968,4.0000,7.0000,0.0000,17.1973,3.9521,-0.0219,1.0249,-0.2298},
				{0.0200,25.9616,-0.7809,17.5143,4.0479,0.0024,-0.9764,16.5768,4.0000,7.0000,0.0000,17.2763,3.9521,-0.0024,0.9765,-0.2306},
				{0.0200,26.0395,-0.7992,17.5953,4.0476,-0.0162,-0.9280,16.6568,4.0000,7.0000,0.0000,17.3554,3.9524,0.0162,0.9280,-0.2314},
				{0.0200,26.1174,-0.8176,17.6762,4.0469,-0.0337,-0.8794,16.7368,4.0000,7.0000,0.0000,17.4344,3.9531,0.0337,0.8794,-0.2322},
				{0.0200,26.1952,-0.8361,17.7571,4.0459,-0.0504,-0.8309,16.8168,4.0000,7.0000,0.0000,17.5135,3.9541,0.0504,0.8309,-0.2330},
				{0.0200,26.2731,-0.8546,17.8380,4.0446,-0.0660,-0.7824,16.8968,4.0000,7.0000,0.0000,17.5926,3.9554,0.0660,0.7824,-0.2338},
				{0.0200,26.3509,-0.8731,17.9189,4.0430,-0.0807,-0.7338,16.9768,4.0000,7.0000,0.0000,17.6718,3.9570,0.0807,0.7338,-0.2345},
				{0.0200,26.4287,-0.8917,17.9997,4.0411,-0.0944,-0.6852,17.0568,4.0000,7.0000,0.0000,17.7509,3.9589,0.0944,0.6852,-0.2352},
				{0.0200,26.5065,-0.9104,18.0805,4.0390,-0.1071,-0.6367,17.1368,4.0000,7.0000,0.0000,17.8302,3.9610,0.1071,0.6367,-0.2358},
				{0.0200,26.5843,-0.9291,18.1612,4.0366,-0.1189,-0.5881,17.2168,4.0000,7.0000,0.0000,17.9094,3.9634,0.1189,0.5881,-0.2364},
				{0.0200,26.6620,-0.9479,18.2419,4.0340,-0.1297,-0.5395,17.2968,4.0000,7.0000,0.0000,17.9887,3.9660,0.1297,0.5395,-0.2370},
				{0.0200,26.7398,-0.9667,18.3225,4.0312,-0.1395,-0.4909,17.3768,4.0000,7.0000,0.0000,18.0681,3.9688,0.1395,0.4909,-0.2375},
				{0.0200,26.8175,-0.9855,18.4031,4.0282,-0.1483,-0.4424,17.4568,4.0000,7.0000,0.0000,18.1476,3.9718,0.1483,0.4424,-0.2380},
				{0.0200,26.8953,-1.0044,18.4836,4.0251,-0.1562,-0.3939,17.5368,4.0000,7.0000,0.0000,18.2271,3.9749,0.1562,0.3939,-0.2384},
				{0.0200,26.9730,-1.0233,18.5640,4.0218,-0.1631,-0.3453,17.6168,4.0000,7.0000,0.0000,18.3066,3.9782,0.1631,0.3453,-0.2388},
				{0.0200,27.0507,-1.0423,18.6444,4.0185,-0.1691,-0.2968,17.6968,4.0000,7.0000,0.0000,18.3862,3.9815,0.1691,0.2968,-0.2391},
				{0.0200,27.1284,-1.0612,18.7247,4.0150,-0.1740,-0.2483,17.7768,4.0000,7.0000,0.0000,18.4659,3.9850,0.1740,0.2483,-0.2394},
				{0.0200,27.2062,-1.0802,18.8049,4.0114,-0.1780,-0.1998,17.8568,4.0000,7.0000,0.0000,18.5457,3.9886,0.1780,0.1998,-0.2396},
				{0.0200,27.2839,-1.0992,18.8851,4.0078,-0.1810,-0.1513,17.9368,4.0000,7.0000,0.0000,18.6256,3.9922,0.1810,0.1513,-0.2397},
				{0.0200,27.3616,-1.1182,18.9651,4.0041,-0.1831,-0.1029,18.0168,4.0000,7.0000,0.0000,18.7055,3.9959,0.1831,0.1029,-0.2398},
				{0.0200,27.4393,-1.1372,19.0452,4.0005,-0.1842,-0.0544,18.0968,4.0000,7.0000,0.0000,18.7855,3.9995,0.1842,0.0544,-0.2398},
				{0.0200,27.5170,-1.1562,19.1251,3.9968,-0.1843,-0.0060,18.1768,4.0000,7.0000,0.0000,18.8655,4.0032,0.1843,0.0060,-0.2397},
				{0.0200,27.5947,-1.1751,19.2049,3.9931,-0.1835,0.0425,18.2568,4.0000,7.0000,0.0000,18.9457,4.0069,0.1835,-0.0425,-0.2396},
				{0.0200,27.6724,-1.1941,19.2847,3.9895,-0.1816,0.0910,18.3368,4.0000,7.0000,0.0000,19.0259,4.0105,0.1816,-0.0910,-0.2394},
				{0.0200,27.7502,-1.2131,19.3645,3.9859,-0.1789,0.1394,18.4168,4.0000,7.0000,0.0000,19.1062,4.0141,0.1789,-0.1394,-0.2392},
				{0.0200,27.8279,-1.2320,19.4441,3.9824,-0.1751,0.1879,18.4968,4.0000,7.0000,0.0000,19.1865,4.0176,0.1751,-0.1879,-0.2389},
				{0.0200,27.9056,-1.2509,19.5237,3.9790,-0.1704,0.2364,18.5768,4.0000,7.0000,0.0000,19.2669,4.0210,0.1704,-0.2364,-0.2385},
				{0.0200,27.9834,-1.2698,19.6032,3.9757,-0.1647,0.2849,18.6568,4.0000,7.0000,0.0000,19.3474,4.0243,0.1647,-0.2849,-0.2381},
				{0.0200,28.0611,-1.2887,19.6826,3.9725,-0.1580,0.3334,18.7368,4.0000,7.0000,0.0000,19.4280,4.0275,0.1580,-0.3334,-0.2377},
				{0.0200,28.1389,-1.3075,19.7620,3.9695,-0.1504,0.3819,18.8168,4.0000,7.0000,0.0000,19.5086,4.0305,0.1504,-0.3819,-0.2371},
				{0.0200,28.2166,-1.3263,19.8414,3.9667,-0.1418,0.4305,18.8968,4.0000,7.0000,0.0000,19.5892,4.0333,0.1418,-0.4305,-0.2366},
				{0.0200,28.2944,-1.3450,19.9207,3.9640,-0.1322,0.4790,18.9768,4.0000,7.0000,0.0000,19.6700,4.0360,0.1322,-0.4790,-0.2360},
				{0.0200,28.3722,-1.3637,19.9999,3.9616,-0.1216,0.5276,19.0568,4.0000,7.0000,0.0000,19.7507,4.0384,0.1216,-0.5276,-0.2353},
				{0.0200,28.4500,-1.3823,20.0791,3.9594,-0.1101,0.5761,19.1368,4.0000,7.0000,0.0000,19.8315,4.0406,0.1101,-0.5761,-0.2347},
				{0.0200,28.5278,-1.4009,20.1582,3.9575,-0.0976,0.6247,19.2168,4.0000,7.0000,0.0000,19.9124,4.0425,0.0976,-0.6247,-0.2339},
				{0.0200,28.6056,-1.4194,20.2373,3.9558,-0.0841,0.6733,19.2968,4.0000,7.0000,0.0000,19.9933,4.0442,0.0841,-0.6733,-0.2332},
				{0.0200,28.6835,-1.4379,20.3164,3.9544,-0.0697,0.7219,19.3768,4.0000,7.0000,0.0000,20.0742,4.0456,0.0697,-0.7219,-0.2324},
				{0.0200,28.7613,-1.4563,20.3955,3.9533,-0.0543,0.7704,19.4568,4.0000,7.0000,0.0000,20.1551,4.0467,0.0543,-0.7704,-0.2316},
				{0.0200,28.8392,-1.4746,20.4745,3.9525,-0.0379,0.8190,19.5368,4.0000,7.0000,0.0000,20.2361,4.0475,0.0379,-0.8190,-0.2308},
				{0.0200,28.9171,-1.4929,20.5536,3.9521,-0.0206,0.8675,19.6168,4.0000,7.0000,0.0000,20.3170,4.0479,0.0206,-0.8675,-0.2300},
				{0.0200,28.9950,-1.5111,20.6326,3.9521,-0.0022,0.9160,19.6968,4.0000,7.0000,0.0000,20.3980,4.0479,0.0022,-0.9160,-0.2292},
				{0.0200,29.0702,-1.5286,20.7089,3.8141,-6.9002,-344.8972,19.7740,3.8600,-7.0000,0.0000,20.4761,3.9059,-7.0998,-355.1027,-0.2285},
				{0.0200,29.1427,-1.5454,20.7824,3.6764,-6.8847,0.7748,19.8484,3.7200,-7.0000,0.0000,20.5514,3.7636,-7.1153,-0.7748,-0.2277},
				{0.0200,29.2124,-1.5615,20.8532,3.5389,-6.8722,0.6256,19.9200,3.5800,-7.0000,0.0000,20.6238,3.6211,-7.1278,-0.6256,-0.2270},
				{0.0200,29.2794,-1.5770,20.9212,3.4017,-6.8626,0.4808,19.9888,3.4400,-7.0000,0.0000,20.6934,3.4783,-7.1374,-0.4808,-0.2264},
				{0.0200,29.3438,-1.5918,20.9865,3.2646,-6.8557,0.3420,20.0548,3.3000,-7.0000,0.0000,20.7601,3.3354,-7.1443,-0.3420,-0.2258},
				{0.0200,29.4054,-1.6059,21.0491,3.1275,-6.8515,0.2104,20.1180,3.1600,-7.0000,0.0000,20.8239,3.1925,-7.1485,-0.2104,-0.2253},
				{0.0200,29.4642,-1.6194,21.1089,2.9905,-6.8498,0.0872,20.1784,3.0200,-7.0000,0.0000,20.8849,3.0495,-7.1502,-0.0872,-0.2248},
				{0.0200,29.5204,-1.6322,21.1660,2.8535,-6.8503,-0.0266,20.2360,2.8800,-7.0000,0.0000,20.9431,2.9065,-7.1497,0.0266,-0.2243},
				{0.0200,29.5738,-1.6444,21.2203,2.7165,-6.8529,-0.1302,20.2908,2.7400,-7.0000,0.0000,20.9983,2.7635,-7.1471,0.1302,-0.2239},
				{0.0200,29.6245,-1.6560,21.2719,2.5793,-6.8574,-0.2230,20.3428,2.6000,-7.0000,0.0000,21.0507,2.6207,-7.1426,0.2230,-0.2236},
				{0.0200,29.6725,-1.6669,21.3207,2.4421,-6.8635,-0.3045,20.3920,2.4600,-7.0000,0.0000,21.1003,2.4779,-7.1365,0.3044,-0.2233},
				{0.0200,29.7178,-1.6771,21.3668,2.3046,-6.8709,-0.3743,20.4384,2.3200,-7.0000,0.0000,21.1470,2.3354,-7.1291,0.3743,-0.2230},
				{0.0200,29.7603,-1.6868,21.4102,2.1670,-6.8796,-0.4324,20.4820,2.1800,-7.0000,0.0000,21.1909,2.1930,-7.1204,0.4324,-0.2228},
				{0.0200,29.8001,-1.6958,21.4507,2.0293,-6.8892,-0.4786,20.5228,2.0400,-7.0000,0.0000,21.2319,2.0507,-7.1108,0.4786,-0.2226},
				{0.0200,29.8371,-1.7042,21.4886,1.8913,-6.8994,-0.5131,20.5608,1.9000,-7.0000,0.0000,21.2700,1.9087,-7.1006,0.5131,-0.2225},
				{0.0200,29.8715,-1.7119,21.5236,1.7531,-6.9102,-0.5360,20.5960,1.7600,-7.0000,0.0000,21.3054,1.7669,-7.0898,0.5360,-0.2224},
				{0.0200,29.9031,-1.7191,21.5559,1.6147,-6.9211,-0.5477,20.6284,1.6200,-7.0000,0.0000,21.3379,1.6253,-7.0789,0.5477,-0.2223},
				{0.0200,29.9319,-1.7256,21.5854,1.4760,-6.9321,-0.5485,20.6580,1.4800,-7.0000,0.0000,21.3676,1.4840,-7.0679,0.5485,-0.2222},
				{0.0200,29.9581,-1.7315,21.6122,1.3372,-6.9429,-0.5390,20.6848,1.3400,-7.0000,0.0000,21.3944,1.3428,-7.0571,0.5390,-0.2221},
				{0.0200,29.9815,-1.7368,21.6362,1.1981,-6.9532,-0.5197,20.7088,1.2000,-7.0000,0.0000,21.4185,1.2019,-7.0468,0.5197,-0.2221},
				{0.0200,30.0022,-1.7415,21.6573,1.0588,-6.9631,-0.4914,20.7300,1.0600,-7.0000,0.0000,21.4397,1.0612,-7.0369,0.4914,-0.2221},
				{0.0200,30.0201,-1.7455,21.6757,0.9194,-6.9722,-0.4547,20.7484,0.9200,-7.0000,0.0000,21.4581,0.9206,-7.0278,0.4547,-0.2221},
				{0.0200,30.0353,-1.7489,21.6913,0.7798,-6.9804,-0.4105,20.7640,0.7800,-7.0000,0.0000,21.4737,0.7802,-7.0196,0.4105,-0.2221},
				{0.0200,30.0400,-1.7500,21.6961,0.2388,-27.0479,-1003.3765,20.7688,0.6400,-7.0000,0.0000,21.4785,0.2388,-27.0690,-1002.4709,-0.2221},
				{0.0200,30.0400,-1.7500,21.6961,0.0000,-11.9409,755.3520,20.7688,0.5000,-7.0000,0.0000,21.4785,0.0000,-11.9422,756.3427,-0.2221},
				{0.0200,30.0400,-1.7500,21.6961,0.0000,0.0000,597.0435,20.7688,0.3600,-7.0000,0.0000,21.4785,0.0000,0.0000,597.1091,-0.2221},
				{0.0200,30.0400,-1.7500,21.6961,0.0000,0.0000,0.0000,20.7688,0.2200,-7.0000,0.0000,21.4785,0.0000,0.0000,0.0000,-0.2221},
				{0.0200,30.0400,-1.7500,21.6961,0.0000,0.0000,0.0000,20.7688,0.0800,-7.0000,0.0000,21.4785,0.0000,0.0000,0.0000,-0.2221},
				{0.0200,30.0400,-1.7500,21.6961,0.0000,0.0000,0.0000,20.7688,-0.0600,-7.0000,0.0000,21.4785,0.0000,0.0000,0.0000,-0.2221},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}