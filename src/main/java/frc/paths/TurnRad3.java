package frc.paths;

import com.team319.trajectory.Path;

public class TurnRad3 extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,0.0028,-0.0000,0.0028,0.1400,7.0000,0.0000,0.0028,0.1400,7.0000,0.0000,0.0028,0.1400,7.0000,0.0000,-0.0000},
				{0.0200,0.0084,-0.0000,0.0084,0.2801,7.0029,0.1428,0.0084,0.2800,7.0000,0.0000,0.0084,0.2799,6.9971,-0.1428,-0.0000},
				{0.0200,0.0168,-0.0000,0.0168,0.4202,7.0068,0.1962,0.0168,0.4200,7.0000,0.0000,0.0168,0.4198,6.9932,-0.1962,-0.0000},
				{0.0200,0.0280,-0.0000,0.0280,0.5605,7.0132,0.3205,0.0280,0.5600,7.0000,0.0000,0.0280,0.5595,6.9868,-0.3205,-0.0000},
				{0.0200,0.0420,-0.0000,0.0420,0.7009,7.0217,0.4264,0.0420,0.7000,7.0000,0.0000,0.0420,0.6991,6.9783,-0.4264,-0.0000},
				{0.0200,0.0588,-0.0000,0.0589,0.8415,7.0323,0.5315,0.0588,0.8400,7.0000,0.0000,0.0587,0.8385,6.9677,-0.5315,-0.0001},
				{0.0200,0.0784,-0.0000,0.0785,0.9824,7.0451,0.6358,0.0784,0.9800,7.0000,0.0000,0.0783,0.9776,6.9549,-0.6358,-0.0001},
				{0.0200,0.1008,-0.0000,0.1010,1.1236,7.0598,0.7391,0.1008,1.1200,7.0000,0.0000,0.1006,1.1164,6.9402,-0.7391,-0.0002},
				{0.0200,0.1260,-0.0000,0.1263,1.2652,7.0767,0.8414,0.1260,1.2600,7.0000,0.0000,0.1257,1.2548,6.9233,-0.8414,-0.0002},
				{0.0200,0.1540,-0.0000,0.1544,1.4071,7.0955,0.9427,0.1540,1.4000,7.0000,0.0000,0.1536,1.3929,6.9045,-0.9427,-0.0004},
				{0.0200,0.1848,-0.0000,0.1854,1.5494,7.1164,1.0432,0.1848,1.5400,7.0000,0.0000,0.1842,1.5306,6.8836,-1.0432,-0.0005},
				{0.0200,0.2184,-0.0001,0.2193,1.6922,7.1393,1.1429,0.2184,1.6800,7.0000,0.0000,0.2175,1.6678,6.8607,-1.1429,-0.0007},
				{0.0200,0.2548,-0.0001,0.2560,1.8355,7.1641,1.2422,0.2548,1.8200,7.0000,0.0000,0.2536,1.8045,6.8359,-1.2422,-0.0010},
				{0.0200,0.2940,-0.0001,0.2956,1.9793,7.1909,1.3413,0.2940,1.9600,7.0000,0.0000,0.2924,1.9407,6.8091,-1.3413,-0.0013},
				{0.0200,0.3360,-0.0002,0.3380,2.1237,7.2197,1.4406,0.3360,2.1000,7.0000,0.0000,0.3340,2.0763,6.7803,-1.4406,-0.0017},
				{0.0200,0.3808,-0.0003,0.3834,2.2687,7.2505,1.5407,0.3808,2.2400,7.0000,0.0000,0.3782,2.2113,6.7494,-1.5407,-0.0022},
				{0.0200,0.4284,-0.0004,0.4317,2.4144,7.2834,1.6421,0.4284,2.3800,7.0000,0.0000,0.4251,2.3456,6.7166,-1.6421,-0.0028},
				{0.0200,0.4788,-0.0006,0.4829,2.5607,7.3183,1.7454,0.4788,2.5200,7.0000,0.0000,0.4747,2.4793,6.6817,-1.7455,-0.0035},
				{0.0200,0.5320,-0.0008,0.5371,2.7078,7.3553,1.8516,0.5320,2.6600,7.0000,0.0000,0.5269,2.6122,6.6447,-1.8516,-0.0043},
				{0.0200,0.5880,-0.0010,0.5942,2.8557,7.3946,1.9615,0.5880,2.8000,7.0000,0.0000,0.5818,2.7443,6.6054,-1.9615,-0.0052},
				{0.0200,0.6468,-0.0014,0.6543,3.0045,7.4361,2.0761,0.6468,2.9400,7.0000,0.0000,0.6393,2.8755,6.5639,-2.0761,-0.0063},
				{0.0200,0.7084,-0.0018,0.7173,3.1541,7.4800,2.1965,0.7084,3.0800,7.0000,0.0000,0.6995,3.0059,6.5200,-2.1966,-0.0075},
				{0.0200,0.7728,-0.0023,0.7834,3.3046,7.5265,2.3242,0.7728,3.2200,7.0000,0.0000,0.7622,3.1354,6.4735,-2.3243,-0.0089},
				{0.0200,0.8400,-0.0030,0.8526,3.4561,7.5757,2.4604,0.8400,3.3600,7.0000,0.0000,0.8274,3.2639,6.4243,-2.4605,-0.0106},
				{0.0200,0.9100,-0.0038,0.9247,3.6087,7.6278,2.6069,0.9100,3.5000,7.0000,0.0000,0.8953,3.3913,6.3721,-2.6070,-0.0124},
				{0.0200,0.9828,-0.0047,1.0000,3.7623,7.6831,2.7653,0.9828,3.6400,7.0000,0.0000,0.9656,3.5177,6.3168,-2.7655,-0.0144},
				{0.0200,1.0584,-0.0059,1.0783,3.9172,7.7419,2.9378,1.0584,3.7800,7.0000,0.0000,1.0385,3.6428,6.2581,-2.9380,-0.0167},
				{0.0200,1.1368,-0.0073,1.1598,4.0732,7.8044,3.1264,1.1368,3.9200,7.0000,0.0000,1.1138,3.7668,6.1955,-3.1266,-0.0193},
				{0.0200,1.2179,-0.0090,1.2444,4.2307,7.8711,3.3337,1.2180,4.0600,7.0000,0.0000,1.1916,3.8893,6.1289,-3.3340,-0.0222},
				{0.0200,1.3019,-0.0110,1.3322,4.3895,7.9424,3.5623,1.3020,4.2000,7.0000,0.0000,1.2718,4.0105,6.0576,-3.5627,-0.0254},
				{0.0200,1.3887,-0.0134,1.4232,4.5499,8.0187,3.8154,1.3888,4.3400,7.0000,0.0000,1.3544,4.1301,5.9813,-3.8159,-0.0289},
				{0.0200,1.4782,-0.0161,1.5174,4.7119,8.1006,4.0963,1.4784,4.4800,7.0000,0.0000,1.4394,4.2481,5.8994,-4.0969,-0.0328},
				{0.0200,1.5706,-0.0194,1.6149,4.8757,8.1888,4.4089,1.5708,4.6200,7.0000,0.0000,1.5267,4.3643,5.8112,-4.4095,-0.0371},
				{0.0200,1.6657,-0.0231,1.7158,5.0414,8.2839,4.7572,1.6660,4.7600,7.0000,0.0000,1.6162,4.4786,5.7160,-4.7581,-0.0418},
				{0.0200,1.7636,-0.0275,1.8200,5.2091,8.3868,5.1461,1.7640,4.9000,7.0000,0.0000,1.7080,4.5909,5.6131,-5.1470,-0.0470},
				{0.0200,1.8643,-0.0325,1.9275,5.3791,8.4984,5.5806,1.8648,5.0400,7.0000,0.0000,1.8021,4.7009,5.5014,-5.5818,-0.0527},
				{0.0200,1.9677,-0.0383,2.0386,5.5515,8.6198,6.0666,1.9684,5.1800,7.0000,0.0000,1.8982,4.8085,5.3801,-6.0680,-0.0590},
				{0.0200,2.0739,-0.0449,2.1531,5.7265,8.7520,6.6102,2.0748,5.3200,7.0000,0.0000,1.9965,4.9135,5.2478,-6.6119,-0.0658},
				{0.0200,2.1829,-0.0525,2.2712,5.9044,8.8964,7.2184,2.1840,5.4600,7.0000,0.0000,2.0968,5.0156,5.1034,-7.2205,-0.0733},
				{0.0200,2.2945,-0.0611,2.3929,6.0855,9.0543,7.8985,2.2960,5.6000,7.0000,0.0000,2.1991,5.1145,4.9454,-7.9011,-0.0814},
				{0.0200,2.4089,-0.0710,2.5183,6.2701,9.2275,8.6584,2.4108,5.7400,7.0000,0.0000,2.3033,5.2099,4.7722,-8.6613,-0.0903},
				{0.0200,2.5260,-0.0821,2.6475,6.4584,9.4176,9.5057,2.5284,5.8800,7.0000,0.0000,2.4093,5.3015,4.5820,-9.5094,-0.1001},
				{0.0200,2.6457,-0.0948,2.7805,6.6509,9.6266,10.4486,2.6488,6.0200,7.0000,0.0000,2.5171,5.3890,4.3729,-10.4529,-0.1107},
				{0.0200,2.7681,-0.1091,2.9174,6.8481,9.8565,11.4939,2.7720,6.1600,7.0000,0.0000,2.6266,5.4719,4.1429,-11.4993,-0.1222},
				{0.0200,2.8930,-0.1252,3.0584,7.0503,10.1094,12.6475,2.8980,6.3000,7.0000,0.0000,2.7375,5.5497,3.8899,-12.6540,-0.1348},
				{0.0200,3.0205,-0.1434,3.2036,7.2580,10.3876,13.9122,3.0268,6.4400,7.0000,0.0000,2.8500,5.6219,3.6115,-13.9200,-0.1486},
				{0.0200,3.1505,-0.1639,3.3530,7.4719,10.6934,15.2860,3.1584,6.5800,7.0000,0.0000,2.9637,5.6880,3.3055,-15.2956,-0.1636},
				{0.0200,3.2830,-0.1868,3.5069,7.6924,11.0286,16.7601,3.2928,6.7200,7.0000,0.0000,3.0787,5.7474,2.9701,-16.7716,-0.1799},
				{0.0200,3.4177,-0.2126,3.6653,7.9203,11.3949,18.3144,3.4300,6.8600,7.0000,0.0000,3.1947,5.7995,2.6035,-18.3283,-0.1977},
				{0.0200,3.5547,-0.2414,3.8284,8.1562,11.7931,19.9127,3.5700,7.0000,7.0000,0.0000,3.3116,5.8436,2.2050,-19.9297,-0.2172},
				{0.0200,3.6938,-0.2736,3.9964,8.4007,12.2230,21.4962,3.7128,7.1400,7.0000,0.0000,3.4291,5.8791,1.7746,-21.5164,-0.2384},
				{0.0200,3.8349,-0.3096,4.1695,8.6543,12.6825,22.9737,3.8584,7.2800,7.0000,0.0000,3.5472,5.9054,1.3147,-22.9980,-0.2615},
				{0.0200,3.9778,-0.3497,4.3479,8.9177,13.1667,24.2115,4.0068,7.4200,7.0000,0.0000,3.6657,5.9220,0.8299,-24.2404,-0.2866},
				{0.0200,4.1222,-0.3944,4.5317,9.1910,13.6671,25.0205,4.1580,7.5600,7.0000,0.0000,3.7843,5.9285,0.3288,-25.0543,-0.3141},
				{0.0200,4.2680,-0.4442,4.7212,9.4744,14.1700,25.1428,4.3120,7.7000,7.0000,0.0000,3.9028,5.9250,-0.1749,-25.1820,-0.3439},
				{0.0200,4.4147,-0.4994,4.9165,9.7675,14.6549,24.2427,4.4688,7.8400,7.0000,0.0000,4.0210,5.9118,-0.6606,-24.2869,-0.3763},
				{0.0200,4.5621,-0.5606,5.1179,10.0694,15.0929,21.9040,4.6284,7.9800,7.0000,0.0000,4.1388,5.8898,-1.0997,-21.9527,-0.4114},
				{0.0200,4.7097,-0.6283,5.3255,10.3783,15.4459,17.6476,4.7908,8.1200,7.0000,0.0000,4.2560,5.8608,-1.4536,-17.6987,-0.4494},
				{0.0200,4.8570,-0.7031,5.5393,10.6916,15.6654,10.9754,4.9560,8.2600,7.0000,0.0000,4.3725,5.8273,-1.6742,-11.0257,-0.4903},
				{0.0200,5.0034,-0.7854,5.7594,11.0055,15.6946,1.4591,5.1240,8.4000,7.0000,0.0000,4.4884,5.7932,-1.7042,-1.5038,-0.5341},
				{0.0200,5.1484,-0.8757,5.9857,11.3149,15.4721,-11.1236,5.2948,8.5400,7.0000,0.0000,4.6037,5.7635,-1.4824,11.0910,-0.5807},
				{0.0200,5.2911,-0.9745,6.2180,11.6137,14.9399,-26.6118,5.4684,8.6800,7.0000,0.0000,4.7186,5.7445,-0.9504,26.5993,-0.6300},
				{0.0200,5.4309,-1.0820,6.4559,11.8948,14.0542,-44.2845,5.6448,8.8200,7.0000,0.0000,4.8334,5.7432,-0.0644,44.3000,-0.6817},
				{0.0200,5.5670,-1.1986,6.6989,12.1508,12.7991,-62.7558,5.8240,8.9600,7.0000,0.0000,4.9488,5.7671,1.1917,62.8057,-0.7354},
				{0.0200,5.6985,-1.3243,6.9464,12.3747,11.1983,-80.0370,6.0060,9.1000,7.0000,0.0000,5.0652,5.8230,2.7942,80.1236,-0.7905},
				{0.0200,5.8248,-1.4592,7.1976,12.5612,9.3217,-93.8303,6.1908,9.2400,7.0000,0.0000,5.1836,5.9164,4.6732,93.9504,-0.8463},
				{0.0200,5.9451,-1.6031,7.4518,12.7068,7.2811,-102.0322,6.3784,9.3800,7.0000,0.0000,5.3046,6.0508,6.7167,102.1760,-0.9022},
				{0.0200,6.0589,-1.7558,7.7080,12.8111,5.2151,-103.2977,6.5688,9.5200,7.0000,0.0000,5.4291,6.2265,8.7857,103.4508,-0.9576},
				{0.0200,6.1658,-1.9167,7.9655,12.8764,3.2663,-97.4420,6.7620,9.6600,7.0000,0.0000,5.5579,6.4412,10.7375,97.5882,-1.0117},
				{0.0200,6.2653,-2.0855,8.2237,12.9076,1.5563,-85.4973,6.9580,9.8000,7.0000,0.0000,5.6917,6.6902,12.4499,85.6223,-1.0639},
				{0.0200,6.3574,-2.2617,8.4819,12.9109,0.1684,-69.3957,7.1568,9.9400,7.0000,0.0000,5.8311,6.9670,13.8397,69.4903,-1.1139},
				{0.0200,6.4413,-2.4432,8.7377,12.7922,-5.9354,-305.1933,7.3568,10.0000,7.0000,0.0000,5.9752,7.2060,11.9470,-94.6379,-1.1608},
				{0.0200,6.5170,-2.6283,8.9895,12.5900,-10.1095,-208.7041,7.5568,10.0000,7.0000,0.0000,6.1234,7.4084,10.1224,-91.2306,-1.2044},
				{0.0200,6.5848,-2.8165,9.2373,12.3891,-10.0452,3.2139,7.7568,10.0000,7.0000,0.0000,6.2756,7.6095,10.0570,-3.2659,-1.2445},
				{0.0200,6.6454,-3.0071,9.4812,12.1941,-9.7523,14.6459,7.9568,10.0000,7.0000,0.0000,6.4317,7.8048,9.7629,-14.7088,-1.2814},
				{0.0200,6.6991,-3.1997,9.7213,12.0079,-9.3076,22.2339,8.1568,10.0000,7.0000,0.0000,6.5915,7.9911,9.3169,-22.2997,-1.3152},
				{0.0200,6.7467,-3.3939,9.9580,11.8324,-8.7743,26.6662,8.3568,10.0000,7.0000,0.0000,6.7548,8.1668,8.7823,-26.7301,-1.3460},
				{0.0200,6.7885,-3.5895,10.1914,11.6684,-8.2006,28.6874,8.5568,10.0000,7.0000,0.0000,6.9214,8.3309,8.2073,-28.7463,-1.3740},
				{0.0200,6.8250,-3.7861,10.4217,11.5160,-7.6211,28.9759,8.7568,10.0000,7.0000,0.0000,7.0911,8.4835,7.6268,-29.0282,-1.3995},
				{0.0200,6.8568,-3.9836,10.6492,11.3748,-7.0592,28.0909,8.9568,10.0000,7.0000,0.0000,7.2636,8.6247,7.0640,-28.1365,-1.4226},
				{0.0200,6.8842,-4.1817,10.8741,11.2442,-6.5300,26.4632,9.1568,10.0000,7.0000,0.0000,7.4387,8.7554,6.5340,-26.5020,-1.4435},
				{0.0200,6.9077,-4.3803,11.0965,11.1234,-6.0419,24.4060,9.3568,10.0000,7.0000,0.0000,7.6162,8.8763,6.0452,-24.4390,-1.4624},
				{0.0200,6.9276,-4.5793,11.3168,11.0114,-5.5991,22.1373,9.5568,10.0000,7.0000,0.0000,7.7960,8.9884,5.6019,-22.1650,-1.4794},
				{0.0200,6.9443,-4.7786,11.5349,10.9073,-5.2031,19.8012,9.7568,10.0000,7.0000,0.0000,7.9778,9.0925,5.2054,-19.8244,-1.4947},
				{0.0200,6.9581,-4.9781,11.7511,10.8103,-4.8533,17.4871,9.9568,10.0000,7.0000,0.0000,8.1616,9.1896,4.8553,-17.5065,-1.5083},
				{0.0200,6.9694,-5.1778,11.9655,10.7193,-4.5484,15.2460,10.1568,10.0000,7.0000,0.0000,8.3472,9.2806,4.5501,-15.2622,-1.5204},
				{0.0200,6.9784,-5.3776,12.1782,10.6336,-4.2864,13.1015,10.3568,10.0000,7.0000,0.0000,8.5346,9.3663,4.2878,-13.1152,-1.5310},
				{0.0200,6.9854,-5.5775,12.3892,10.5523,-4.0652,11.0591,10.5568,10.0000,7.0000,0.0000,8.7235,9.4477,4.0663,-11.0706,-1.5403},
				{0.0200,6.9907,-5.7774,12.5987,10.4746,-3.8830,9.1112,10.7568,10.0000,7.0000,0.0000,8.9140,9.5253,3.8839,-9.1210,-1.5483},
				{0.0200,6.9945,-5.9774,12.8067,10.3998,-3.7381,7.2420,10.9568,10.0000,7.0000,0.0000,9.1060,9.6001,3.7389,-7.2504,-1.5550},
				{0.0200,6.9971,-6.1774,13.0133,10.3272,-3.6296,5.4293,11.1568,10.0000,7.0000,0.0000,9.2995,9.6727,3.6302,-5.4368,-1.5605},
				{0.0200,6.9987,-6.3774,13.2184,10.2561,-3.5566,3.6462,11.3568,10.0000,7.0000,0.0000,9.4944,9.7439,3.5571,-3.6529,-1.5648},
				{0.0200,6.9995,-6.5774,13.4221,10.1857,-3.5194,1.8613,11.5568,10.0000,7.0000,0.0000,9.6907,9.8143,3.5198,-1.8674,-1.5679},
				{0.0200,6.9999,-6.7774,13.6244,10.1154,-3.5186,0.0385,11.7568,10.0000,7.0000,0.0000,9.8883,9.8846,3.5189,-0.0443,-1.5699},
				{0.0200,7.0000,-6.9774,13.8253,10.0442,-3.5559,-1.8636,11.9568,10.0000,7.0000,0.0000,10.0875,9.9558,3.5560,1.8578,-1.5706},
				{0.0200,7.0000,-7.1774,14.0259,10.0309,-0.6693,144.3331,12.1568,10.0000,7.0000,0.0000,10.2868,9.9691,0.6693,-144.3391,-1.5711},
				{0.0200,6.9998,-7.3774,14.2280,10.1060,3.7591,221.4186,12.3568,10.0000,7.0000,0.0000,10.4847,9.8940,-3.7592,-221.4253,-1.5729},
				{0.0200,6.9991,-7.5774,14.4316,10.1809,3.7441,-0.7492,12.5568,10.0000,7.0000,0.0000,10.6811,9.8191,-3.7444,0.7426,-1.5760},
				{0.0200,6.9976,-7.7774,14.6367,10.2554,3.7246,-0.9792,12.7568,10.0000,7.0000,0.0000,10.8760,9.7446,-3.7249,0.9727,-1.5802},
				{0.0200,6.9952,-7.9773,14.8433,10.3303,3.7461,1.0768,12.9568,10.0000,7.0000,0.0000,11.0694,9.6696,-3.7466,-1.0835,-1.5858},
				{0.0200,6.9915,-8.1773,15.0515,10.4065,3.8072,3.0552,13.1568,10.0000,7.0000,0.0000,11.2613,9.5935,-3.8079,-3.0624,-1.5926},
				{0.0200,6.9864,-8.3772,15.2612,10.4846,3.9072,4.9998,13.3568,10.0000,7.0000,0.0000,11.4516,9.5153,-3.9080,-5.0078,-1.6008},
				{0.0200,6.9795,-8.5771,15.4725,10.5655,4.0461,6.9472,13.5568,10.0000,7.0000,0.0000,11.6403,9.4344,-4.0471,-6.9562,-1.6103},
				{0.0200,6.9705,-8.7769,15.6855,10.6500,4.2247,8.9275,13.7568,10.0000,7.0000,0.0000,11.8273,9.3499,-4.2259,-8.9379,-1.6212},
				{0.0200,6.9592,-8.9766,15.9003,10.7389,4.4440,10.9642,13.9568,10.0000,7.0000,0.0000,12.0125,9.2610,-4.4454,-10.9764,-1.6336},
				{0.0200,6.9453,-9.1761,16.1169,10.8330,4.7054,13.0725,14.1568,10.0000,7.0000,0.0000,12.1958,9.1668,-4.7072,-13.0869,-1.6476},
				{0.0200,6.9284,-9.3754,16.3356,10.9332,5.0105,15.2565,14.3568,10.0000,7.0000,0.0000,12.3771,9.0666,-5.0126,-15.2736,-1.6633},
				{0.0200,6.9082,-9.5744,16.5564,11.0404,5.3607,17.5054,14.5568,10.0000,7.0000,0.0000,12.5563,8.9593,-5.3631,-17.5258,-1.6808},
				{0.0200,6.8844,-9.7729,16.7795,11.1556,5.7564,19.7865,14.7568,10.0000,7.0000,0.0000,12.7332,8.8441,-5.7594,-19.8106,-1.7002},
				{0.0200,6.8564,-9.9710,17.0051,11.2795,6.1971,22.0360,14.9568,10.0000,7.0000,0.0000,12.9076,8.7201,-6.2007,-22.0649,-1.7217},
				{0.0200,6.8241,-10.1683,17.2334,11.4131,6.6801,24.1475,15.1568,10.0000,7.0000,0.0000,13.0793,8.5864,-6.6843,-24.1817,-1.7455},
				{0.0200,6.7868,-10.3648,17.4645,11.5571,7.1992,25.9550,15.3568,10.0000,7.0000,0.0000,13.2482,8.4423,-7.2042,-25.9950,-1.7717},
				{0.0200,6.7441,-10.5602,17.6987,11.7120,7.7434,27.2146,15.5568,10.0000,7.0000,0.0000,13.4139,8.2873,-7.7494,-27.2609,-1.8004},
				{0.0200,6.6955,-10.7542,17.9363,11.8779,8.2951,27.5846,15.7568,10.0000,7.0000,0.0000,13.5764,8.1213,-8.3022,-27.6371,-1.8320},
				{0.0200,6.6406,-10.9465,18.1774,12.0544,8.8273,26.6093,15.9568,10.0000,7.0000,0.0000,13.7352,7.9446,-8.8355,-26.6676,-1.8666},
				{0.0200,6.5788,-11.1367,18.4222,12.2405,9.3017,23.7165,16.1568,10.0000,7.0000,0.0000,13.8904,7.7584,-9.3111,-23.7783,-1.9042},
				{0.0200,6.5095,-11.3243,18.6709,12.4338,9.6665,18.2419,16.3568,10.0000,7.0000,0.0000,14.0417,7.5648,-9.6771,-18.3037,-1.9451},
				{0.0200,6.4324,-11.5088,18.9235,12.6309,9.8566,9.5038,16.5568,10.0000,7.0000,0.0000,14.1891,7.3675,-9.8683,-9.5597,-1.9894},
				{0.0200,6.3468,-11.6896,19.1800,12.8268,9.7955,-3.0535,16.7568,10.0000,7.0000,0.0000,14.3325,7.1713,-9.8081,3.0116,-2.0369},
				{0.0200,6.2539,-11.8635,19.4367,12.8315,0.2325,-478.1491,16.9540,9.8600,-7.0000,0.0000,14.4702,6.8865,-14.2410,-221.6424,-2.0869},
				{0.0200,6.1536,-12.0300,19.6929,12.8135,-0.8980,-56.5244,17.1484,9.7200,-7.0000,0.0000,14.6027,6.6243,-13.1091,56.5946,-2.1389},
				{0.0200,6.0463,-12.1887,19.9483,12.7664,-2.3549,-72.8485,17.3400,9.5800,-7.0000,0.0000,14.7305,6.3913,-11.6501,72.9492,-2.1925},
				{0.0200,5.9322,-12.3391,20.2019,12.6847,-4.0866,-86.5838,17.5288,9.4400,-7.0000,0.0000,14.8544,6.1930,-9.9159,86.7096,-2.2470},
				{0.0200,5.8119,-12.4809,20.4532,12.5647,-6.0010,-95.7184,17.7148,9.3000,-7.0000,0.0000,14.9750,6.0330,-7.9987,95.8589,-2.3019},
				{0.0200,5.6859,-12.6139,20.7013,12.4051,-7.9763,-98.7634,17.8980,9.1600,-7.0000,0.0000,15.0933,5.9126,-6.0206,98.9046,-2.3565},
				{0.0200,5.5549,-12.7379,20.9455,12.2075,-9.8797,-95.1744,18.0784,9.0200,-7.0000,0.0000,15.2099,5.8303,-4.1146,95.3018,-2.4101},
				{0.0200,5.4197,-12.8531,21.1850,11.9757,-11.5901,-85.5165,18.2560,8.8800,-7.0000,0.0000,15.3256,5.7823,-2.4022,85.6184,-2.4621},
				{0.0200,5.2811,-12.9594,21.4193,11.7154,-13.0160,-71.2959,18.4308,8.7400,-7.0000,0.0000,15.4408,5.7628,-0.9749,71.3656,-2.5122},
				{0.0200,5.1397,-13.0573,21.6480,11.4333,-14.1067,-54.5352,18.6028,8.6000,-7.0000,0.0000,15.5561,5.7651,0.1165,54.5713,-2.5598},
				{0.0200,4.9962,-13.1471,21.8707,11.1362,-14.8522,-37.2738,18.7720,8.4600,-7.0000,0.0000,15.6718,5.7823,0.8621,37.2798,-2.6048},
				{0.0200,4.8515,-13.2291,22.0873,10.8307,-15.2756,-21.1740,18.9384,8.3200,-7.0000,0.0000,15.7879,5.8080,1.2852,21.1563,-2.6470},
				{0.0200,4.7060,-13.3039,22.2978,10.5223,-15.4221,-7.3241,19.1020,8.1800,-7.0000,0.0000,15.9046,5.8367,1.4310,7.2901,-2.6864},
				{0.0200,4.5603,-13.3719,22.5021,10.2154,-15.3468,3.7672,19.2628,8.0400,-7.0000,0.0000,16.0219,5.8638,1.3548,-3.8107,-2.7229},
				{0.0200,4.4148,-13.4336,22.7003,9.9132,-15.1057,12.0545,19.4208,7.9000,-7.0000,0.0000,16.1396,5.8860,1.1128,-12.1021,-2.7568},
				{0.0200,4.2701,-13.4896,22.8927,9.6182,-14.7498,17.7954,19.5760,7.7600,-7.0000,0.0000,16.2577,5.9011,0.7559,-17.8428,-2.7880},
				{0.0200,4.1264,-13.5403,23.0793,9.3318,-14.3218,21.4006,19.7284,7.6200,-7.0000,0.0000,16.3758,5.9077,0.3270,-21.4452,-2.8168},
				{0.0200,3.9840,-13.5861,23.2604,9.0547,-13.8553,23.3231,19.8780,7.4800,-7.0000,0.0000,16.4939,5.9049,-0.1402,-23.3636,-2.8433},
				{0.0200,3.8431,-13.6276,23.4362,8.7872,-13.3755,23.9899,20.0248,7.3400,-7.0000,0.0000,16.6118,5.8924,-0.6207,-24.0255,-2.8676},
				{0.0200,3.7041,-13.6649,23.6068,8.5292,-12.9002,23.7665,20.1688,7.2000,-7.0000,0.0000,16.7292,5.8705,-1.0967,-23.7973,-2.8899},
				{0.0200,3.5670,-13.6987,23.7724,8.2804,-12.4412,22.9470,20.3100,7.0600,-7.0000,0.0000,16.8460,5.8394,-1.5562,-22.9733,-2.9105},
				{0.0200,3.4320,-13.7291,23.9332,8.0402,-12.0061,21.7564,20.4484,6.9200,-7.0000,0.0000,16.9620,5.7996,-1.9917,-21.7784,-2.9293},
				{0.0200,3.2992,-13.7565,24.0893,7.8083,-11.5989,20.3597,20.5840,6.7800,-7.0000,0.0000,17.0770,5.7516,-2.3993,-20.3783,-2.9466},
				{0.0200,3.1687,-13.7812,24.2410,7.5838,-11.2214,18.8743,20.7168,6.6400,-7.0000,0.0000,17.1909,5.6960,-2.7771,-18.8896,-2.9624},
				{0.0200,3.0406,-13.8034,24.3883,7.3664,-10.8738,17.3796,20.8468,6.5000,-7.0000,0.0000,17.3036,5.6335,-3.1249,-17.3924,-2.9770},
				{0.0200,2.9150,-13.8234,24.5315,7.1553,-10.5553,15.9278,20.9740,6.3600,-7.0000,0.0000,17.4149,5.5647,-3.4437,-15.9383,-2.9904},
				{0.0200,2.7919,-13.8414,24.6704,6.9500,-10.2643,14.5507,21.0984,6.2200,-7.0000,0.0000,17.5247,5.4900,-3.7349,-14.5594,-3.0026},
				{0.0200,2.6714,-13.8576,24.8054,6.7500,-9.9990,13.2660,21.2200,6.0800,-7.0000,0.0000,17.6329,5.4099,-4.0004,-13.2733,-3.0139},
				{0.0200,2.5535,-13.8721,24.9365,6.5548,-9.7573,12.0819,21.3388,5.9400,-7.0000,0.0000,17.7394,5.3251,-4.2421,-12.0878,-3.0242},
				{0.0200,2.4382,-13.8851,25.0638,6.3641,-9.5373,10.9998,21.4548,5.8000,-7.0000,0.0000,17.8441,5.2359,-4.4622,-11.0048,-3.0337},
				{0.0200,2.3256,-13.8968,25.1874,6.1774,-9.3370,10.0175,21.5680,5.6600,-7.0000,0.0000,17.9469,5.1426,-4.6626,-10.0215,-3.0424},
				{0.0200,2.2157,-13.9073,25.3073,5.9943,-9.1544,9.1296,21.6784,5.5200,-7.0000,0.0000,18.0479,5.0457,-4.8453,-9.1329,-3.0504},
				{0.0200,2.1085,-13.9167,25.4236,5.8145,-8.9878,8.3298,21.7860,5.3800,-7.0000,0.0000,18.1468,4.9455,-5.0119,-8.3326,-3.0577},
				{0.0200,2.0041,-13.9251,25.5363,5.6378,-8.8356,7.6111,21.8908,5.2400,-7.0000,0.0000,18.2436,4.8422,-5.1642,-7.6134,-3.0644},
				{0.0200,1.9023,-13.9327,25.6456,5.4639,-8.6962,6.9662,21.9928,5.1000,-7.0000,0.0000,18.3383,4.7361,-5.3036,-6.9680,-3.0705},
				{0.0200,1.8034,-13.9395,25.7514,5.2925,-8.5685,6.3879,22.0920,4.9600,-7.0000,0.0000,18.4309,4.6275,-5.4314,-6.3896,-3.0761},
				{0.0200,1.7072,-13.9455,25.8539,5.1235,-8.4511,5.8698,22.1884,4.8200,-7.0000,0.0000,18.5212,4.5165,-5.5488,-5.8710,-3.0812},
				{0.0200,1.6137,-13.9510,25.9530,4.9566,-8.3430,5.4052,22.2820,4.6800,-7.0000,0.0000,18.6093,4.4034,-5.6569,-5.4063,-3.0858},
				{0.0200,1.5230,-13.9558,26.0489,4.7918,-8.2432,4.9887,22.3728,4.5400,-7.0000,0.0000,18.6950,4.2882,-5.7567,-4.9896,-3.0900},
				{0.0200,1.4352,-13.9602,26.1414,4.6287,-8.1509,4.6148,22.4608,4.4000,-7.0000,0.0000,18.7785,4.1713,-5.8490,-4.6155,-3.0939},
				{0.0200,1.3500,-13.9641,26.2308,4.4674,-8.0653,4.2787,22.5460,4.2600,-7.0000,0.0000,18.8595,4.0526,-5.9346,-4.2793,-3.0974},
				{0.0200,1.2677,-13.9676,26.3169,4.3077,-7.9858,3.9761,22.6284,4.1200,-7.0000,0.0000,18.9382,3.9323,-6.0141,-3.9766,-3.1005},
				{0.0200,1.1882,-13.9708,26.3999,4.1495,-7.9118,3.7031,22.7080,3.9800,-7.0000,0.0000,19.0144,3.8105,-6.0882,-3.7036,-3.1034},
				{0.0200,1.1114,-13.9736,26.4798,3.9926,-7.8426,3.4562,22.7848,3.8400,-7.0000,0.0000,19.0881,3.6874,-6.1573,-3.4566,-3.1059},
				{0.0200,1.0375,-13.9761,26.5565,3.8371,-7.7780,3.2323,22.8588,3.7000,-7.0000,0.0000,19.1594,3.5629,-6.2220,-3.2326,-3.1083},
				{0.0200,0.9663,-13.9784,26.6302,3.6827,-7.7174,3.0284,22.9300,3.5600,-7.0000,0.0000,19.2281,3.4373,-6.2826,-3.0287,-3.1103},
				{0.0200,0.8979,-13.9805,26.7008,3.5295,-7.6606,2.8422,22.9984,3.4200,-7.0000,0.0000,19.2943,3.3105,-6.3394,-2.8423,-3.1122},
				{0.0200,0.8324,-13.9824,26.7683,3.3774,-7.6072,2.6711,23.0640,3.2800,-7.0000,0.0000,19.3580,3.1826,-6.3928,-2.6713,-3.1138},
				{0.0200,0.7696,-13.9841,26.8328,3.2262,-7.5569,2.5133,23.1268,3.1400,-7.0000,0.0000,19.4191,3.0538,-6.4431,-2.5134,-3.1152},
				{0.0200,0.7096,-13.9856,26.8944,3.0760,-7.5095,2.3669,23.1868,3.0000,-7.0000,0.0000,19.4775,2.9240,-6.4904,-2.3670,-3.1165},
				{0.0200,0.6524,-13.9870,26.9529,2.9267,-7.4649,2.2302,23.2440,2.8600,-7.0000,0.0000,19.5334,2.7933,-6.5351,-2.2303,-3.1176},
				{0.0200,0.5981,-13.9883,27.0085,2.7783,-7.4229,2.1018,23.2984,2.7200,-7.0000,0.0000,19.5866,2.6617,-6.5771,-2.1019,-3.1186},
				{0.0200,0.5465,-13.9895,27.0611,2.6306,-7.3833,1.9803,23.3500,2.5800,-7.0000,0.0000,19.6372,2.5294,-6.6167,-1.9804,-3.1195},
				{0.0200,0.4977,-13.9905,27.1108,2.4837,-7.3460,1.8646,23.3988,2.4400,-7.0000,0.0000,19.6852,2.3963,-6.6540,-1.8647,-3.1202},
				{0.0200,0.4517,-13.9915,27.1575,2.3375,-7.3109,1.7536,23.4448,2.3000,-7.0000,0.0000,19.7304,2.2625,-6.6891,-1.7536,-3.1208},
				{0.0200,0.4085,-13.9924,27.2013,2.1919,-7.2780,1.6464,23.4880,2.1600,-7.0000,0.0000,19.7730,2.1281,-6.7220,-1.6464,-3.1214},
				{0.0200,0.3681,-13.9932,27.2423,2.0470,-7.2472,1.5421,23.5284,2.0200,-7.0000,0.0000,19.8128,1.9930,-6.7528,-1.5421,-3.1218},
				{0.0200,0.3305,-13.9939,27.2803,1.9026,-7.2184,1.4401,23.5660,1.8800,-7.0000,0.0000,19.8500,1.8574,-6.7816,-1.4401,-3.1222},
				{0.0200,0.2957,-13.9946,27.3155,1.7588,-7.1916,1.3397,23.6008,1.7400,-7.0000,0.0000,19.8844,1.7212,-6.8084,-1.3397,-3.1225},
				{0.0200,0.2637,-13.9952,27.3478,1.6154,-7.1668,1.2405,23.6328,1.6000,-7.0000,0.0000,19.9161,1.5846,-6.8332,-1.2405,-3.1228},
				{0.0200,0.2345,-13.9958,27.3773,1.4726,-7.1439,1.1419,23.6620,1.4600,-7.0000,0.0000,19.9450,1.4474,-6.8561,-1.1419,-3.1230},
				{0.0200,0.2081,-13.9963,27.4039,1.3301,-7.1231,1.0436,23.6884,1.3200,-7.0000,0.0000,19.9712,1.3099,-6.8769,-1.0436,-3.1232},
				{0.0200,0.1845,-13.9967,27.4276,1.1880,-7.1041,0.9453,23.7120,1.1800,-7.0000,0.0000,19.9947,1.1720,-6.8959,-0.9453,-3.1233},
				{0.0200,0.1637,-13.9971,27.4486,1.0463,-7.0872,0.8468,23.7328,1.0400,-7.0000,0.0000,20.0154,1.0337,-6.9128,-0.8468,-3.1234},
				{0.0200,0.1457,-13.9974,27.4667,0.9048,-7.0723,0.7479,23.7508,0.9000,-7.0000,0.0000,20.0333,0.8952,-6.9277,-0.7479,-3.1235},
				{0.0200,0.1305,-13.9977,27.4819,0.7636,-7.0593,0.6486,23.7660,0.7600,-7.0000,0.0000,20.0484,0.7564,-6.9407,-0.6486,-3.1235},
				{0.0200,0.1181,-13.9979,27.4944,0.6227,-7.0483,0.5488,23.7784,0.6200,-7.0000,0.0000,20.0607,0.6173,-6.9517,-0.5488,-3.1236},
				{0.0200,0.1085,-13.9981,27.5040,0.4819,-7.0393,0.4485,23.7880,0.4800,-7.0000,0.0000,20.0703,0.4781,-6.9607,-0.4485,-3.1236},
				{0.0200,0.1017,-13.9982,27.5108,0.3412,-7.0324,0.3478,23.7948,0.3400,-7.0000,0.0000,20.0771,0.3388,-6.9676,-0.3478,-3.1236},
				{0.0200,0.0977,-13.9983,27.5149,0.2007,-7.0274,0.2466,23.7988,0.2000,-7.0000,0.0000,20.0811,0.1993,-6.9726,-0.2466,-3.1237},
				{0.0200,0.0966,-13.9983,27.5161,0.0602,-7.0245,0.1452,23.8000,0.0600,-7.0000,0.0000,20.0822,0.0598,-6.9755,-0.1452,-3.1237},
				{0.0200,0.0981,-13.9982,27.5177,0.0803,1.0034,401.3972,23.7984,-0.0800,-7.0000,0.0000,20.0838,0.0797,0.9966,398.6028,-3.1236},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}