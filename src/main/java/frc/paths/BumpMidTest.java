package frc.paths;

import com.team319.trajectory.Path;

public class BumpMidTest extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,30.7572,-5.6900,0.0028,0.1400,7.0000,0.0000,0.0028,0.1400,7.0000,0.0000,0.0028,0.1400,7.0000,0.0000,-3.1416},
				{0.0200,30.7516,-5.6900,0.0084,0.2799,6.9934,-0.3289,0.0084,0.2800,7.0000,0.0000,0.0084,0.2801,7.0066,0.3289,-3.1416},
				{0.0200,30.7432,-5.6900,0.0168,0.4196,6.9844,-0.4501,0.0168,0.4200,7.0000,0.0000,0.0168,0.4204,7.0156,0.4501,-3.1416},
				{0.0200,30.7320,-5.6900,0.0280,0.5590,6.9698,-0.7321,0.0280,0.5600,7.0000,0.0000,0.0280,0.5610,7.0302,0.7321,-3.1416},
				{0.0200,30.7180,-5.6900,0.0419,0.6980,6.9504,-0.9673,0.0420,0.7000,7.0000,0.0000,0.0421,0.7020,7.0496,0.9673,-3.1415},
				{0.0200,30.7012,-5.6900,0.0587,0.8365,6.9265,-1.1950,0.0588,0.8400,7.0000,0.0000,0.0589,0.8435,7.0735,1.1950,-3.1415},
				{0.0200,30.6816,-5.6900,0.0781,0.9745,6.8983,-1.4134,0.0784,0.9800,7.0000,0.0000,0.0787,0.9855,7.1017,1.4134,-3.1414},
				{0.0200,30.6592,-5.6900,0.1004,1.1118,6.8659,-1.6208,0.1008,1.1200,7.0000,0.0000,0.1012,1.1282,7.1341,1.6208,-3.1412},
				{0.0200,30.6340,-5.6900,0.1253,1.2484,6.8295,-1.8155,0.1260,1.2600,7.0000,0.0000,0.1267,1.2716,7.1705,1.8155,-3.1410},
				{0.0200,30.6060,-5.6900,0.1530,1.3842,6.7896,-1.9960,0.1540,1.4000,7.0000,0.0000,0.1550,1.4158,7.2104,1.9960,-3.1408},
				{0.0200,30.5752,-5.6901,0.1834,1.5191,6.7464,-2.1608,0.1848,1.5400,7.0000,0.0000,0.1862,1.5609,7.2536,2.1608,-3.1404},
				{0.0200,30.5416,-5.6901,0.2165,1.6531,6.7002,-2.3085,0.2184,1.6800,7.0000,0.0000,0.2203,1.7069,7.2998,2.3085,-3.1400},
				{0.0200,30.5052,-5.6902,0.2522,1.7861,6.6515,-2.4378,0.2548,1.8200,7.0000,0.0000,0.2574,1.8539,7.3485,2.4377,-3.1394},
				{0.0200,30.4660,-5.6903,0.2906,1.9181,6.6005,-2.5473,0.2940,1.9600,7.0000,0.0000,0.2974,2.0019,7.3995,2.5473,-3.1387},
				{0.0200,30.4240,-5.6904,0.3315,2.0491,6.5478,-2.6359,0.3360,2.1000,7.0000,0.0000,0.3405,2.1509,7.4522,2.6359,-3.1378},
				{0.0200,30.3792,-5.6906,0.3751,2.1790,6.4938,-2.7026,0.3808,2.2400,7.0000,0.0000,0.3865,2.3010,7.5062,2.7025,-3.1368},
				{0.0200,30.3316,-5.6909,0.4213,2.3077,6.4388,-2.7462,0.4284,2.3800,7.0000,0.0000,0.4355,2.4523,7.5612,2.7461,-3.1356},
				{0.0200,30.2812,-5.6912,0.4700,2.4354,6.3835,-2.7657,0.4788,2.5200,7.0000,0.0000,0.4876,2.6046,7.6165,2.7656,-3.1342},
				{0.0200,30.2280,-5.6916,0.5212,2.5620,6.3283,-2.7601,0.5320,2.6600,7.0000,0.0000,0.5428,2.7580,7.6717,2.7600,-3.1325},
				{0.0200,30.1720,-5.6922,0.5750,2.6875,6.2738,-2.7285,0.5880,2.8000,7.0000,0.0000,0.6010,2.9125,7.7262,2.7283,-3.1306},
				{0.0200,30.1132,-5.6929,0.6312,2.8119,6.2204,-2.6698,0.6468,2.9400,7.0000,0.0000,0.6624,3.0681,7.7796,2.6696,-3.1285},
				{0.0200,30.0516,-5.6938,0.6899,2.9352,6.1687,-2.5831,0.7084,3.0800,7.0000,0.0000,0.7269,3.2248,7.8313,2.5829,-3.1261},
				{0.0200,29.9872,-5.6949,0.7511,3.0576,6.1193,-2.4673,0.7728,3.2200,7.0000,0.0000,0.7945,3.3824,7.8806,2.4671,-3.1233},
				{0.0200,29.9200,-5.6962,0.8146,3.1791,6.0729,-2.3215,0.8400,3.3600,7.0000,0.0000,0.8654,3.5409,7.9271,2.3213,-3.1203},
				{0.0200,29.8501,-5.6978,0.8806,3.2997,6.0300,-2.1447,0.9100,3.5000,7.0000,0.0000,0.9394,3.7003,7.9699,2.1443,-3.1169},
				{0.0200,29.7773,-5.6997,0.9490,3.4195,5.9913,-1.9357,0.9828,3.6400,7.0000,0.0000,1.0166,3.8605,8.0086,1.9353,-3.1132},
				{0.0200,29.7017,-5.7020,1.0198,3.5387,5.9574,-1.6937,1.0584,3.7800,7.0000,0.0000,1.0970,4.0213,8.0425,1.6933,-3.1092},
				{0.0200,29.6234,-5.7048,1.0929,3.6572,5.9291,-1.4177,1.1368,3.9200,7.0000,0.0000,1.1806,4.1828,8.0709,1.4173,-3.1047},
				{0.0200,29.5422,-5.7079,1.1685,3.7754,5.9069,-1.1071,1.2180,4.0600,7.0000,0.0000,1.2675,4.3446,8.0930,1.1066,-3.1000},
				{0.0200,29.4583,-5.7117,1.2463,3.8932,5.8917,-0.7611,1.3020,4.2000,7.0000,0.0000,1.3577,4.5068,8.1082,0.7606,-3.0948},
				{0.0200,29.3716,-5.7160,1.3265,4.0109,5.8841,-0.3796,1.3888,4.3400,7.0000,0.0000,1.4511,4.6691,8.1158,0.3791,-3.0893},
				{0.0200,29.2822,-5.7209,1.4091,4.1286,5.8849,0.0375,1.4784,4.4800,7.0000,0.0000,1.5477,4.8314,8.1150,-0.0380,-3.0834},
				{0.0200,29.1899,-5.7266,1.4940,4.2465,5.8947,0.4895,1.5708,4.6200,7.0000,0.0000,1.6476,4.9935,8.1052,-0.4900,-3.0771},
				{0.0200,29.0949,-5.7330,1.5813,4.3648,5.9142,0.9755,1.6660,4.7600,7.0000,0.0000,1.7507,5.1552,8.0857,-0.9759,-3.0704},
				{0.0200,28.9972,-5.7403,1.6710,4.4836,5.9440,1.4936,1.7640,4.9000,7.0000,0.0000,1.8570,5.3163,8.0558,-1.4940,-3.0634},
				{0.0200,28.8968,-5.7486,1.7631,4.6033,5.9849,2.0414,1.8648,5.0400,7.0000,0.0000,1.9665,5.4766,8.0150,-2.0417,-3.0561},
				{0.0200,28.7936,-5.7578,1.8576,4.7241,6.0372,2.6155,1.9684,5.1800,7.0000,0.0000,2.0792,5.6359,7.9627,-2.6158,-3.0484},
				{0.0200,28.6877,-5.7681,1.9545,4.8461,6.1014,3.2118,2.0748,5.3200,7.0000,0.0000,2.1951,5.7939,7.8984,-3.2119,-3.0405},
				{0.0200,28.5791,-5.7796,2.0539,4.9697,6.1779,3.8250,2.1840,5.4600,7.0000,0.0000,2.3141,5.9503,7.8219,-3.8250,-3.0322},
				{0.0200,28.4678,-5.7923,2.1558,5.0950,6.2669,4.4492,2.2960,5.6000,7.0000,0.0000,2.4362,6.1050,7.7330,-4.4491,-3.0238},
				{0.0200,28.3539,-5.8063,2.2602,5.2224,6.3685,5.0775,2.4108,5.7400,7.0000,0.0000,2.5614,6.2576,7.6314,-5.0771,-3.0151},
				{0.0200,28.2373,-5.8216,2.3673,5.3520,6.4825,5.7022,2.5284,5.8800,7.0000,0.0000,2.6895,6.4079,7.5174,-5.7017,-3.0062},
				{0.0200,28.1180,-5.8384,2.4769,5.4842,6.6088,6.3154,2.6488,6.0200,7.0000,0.0000,2.8206,6.5558,7.3911,-6.3147,-2.9972},
				{0.0200,27.9962,-5.8567,2.5893,5.6191,6.7470,6.9087,2.7720,6.1600,7.0000,0.0000,2.9547,6.7008,7.2529,-6.9078,-2.9881},
				{0.0200,27.8718,-5.8765,2.7045,5.7571,6.8965,7.4735,2.8980,6.3000,7.0000,0.0000,3.0915,6.8429,7.1035,-7.4724,-2.9790},
				{0.0200,27.7448,-5.8980,2.8224,5.8982,7.0565,8.0018,3.0268,6.4400,7.0000,0.0000,3.2312,6.9818,6.9435,-8.0005,-2.9699},
				{0.0200,27.6152,-5.9211,2.9433,6.0427,7.2262,8.4859,3.1584,6.5800,7.0000,0.0000,3.3735,7.1172,6.7738,-8.4844,-2.9608},
				{0.0200,27.4831,-5.9458,3.0671,6.1908,7.4046,8.9190,3.2928,6.7200,7.0000,0.0000,3.5185,7.2491,6.5954,-8.9175,-2.9519},
				{0.0200,27.3485,-5.9723,3.1940,6.3426,7.5905,9.2956,3.4300,6.8600,7.0000,0.0000,3.6660,7.3773,6.4096,-9.2940,-2.9432},
				{0.0200,27.2114,-6.0004,3.3239,6.4983,7.7827,9.6113,3.5700,7.0000,7.0000,0.0000,3.8161,7.5017,6.2174,-9.6096,-2.9348},
				{0.0200,27.0717,-6.0303,3.4571,6.6579,7.9800,9.8630,3.7128,7.1400,7.0000,0.0000,3.9685,7.6221,6.0201,-9.8613,-2.9267},
				{0.0200,26.9296,-6.0619,3.5935,6.8215,8.1810,10.0492,3.8584,7.2800,7.0000,0.0000,4.1233,7.7385,5.8192,-10.0476,-2.9190},
				{0.0200,26.7850,-6.0952,3.7333,6.9892,8.3844,10.1695,4.0068,7.4200,7.0000,0.0000,4.2803,7.8508,5.6158,-10.1681,-2.9118},
				{0.0200,26.6379,-6.1302,3.8765,7.1610,8.5889,10.2247,4.1580,7.5600,7.0000,0.0000,4.4395,7.9590,5.4114,-10.2235,-2.9051},
				{0.0200,26.4883,-6.1667,4.0233,7.3368,8.7932,10.2159,4.3120,7.7000,7.0000,0.0000,4.6007,8.0631,5.2070,-10.2151,-2.8990},
				{0.0200,26.3362,-6.2048,4.1736,7.5168,8.9961,10.1447,4.4688,7.8400,7.0000,0.0000,4.7640,8.1632,5.0042,-10.1442,-2.8935},
				{0.0200,26.1815,-6.2444,4.3276,7.7007,9.1963,10.0121,4.6284,7.9800,7.0000,0.0000,4.9292,8.2593,4.8039,-10.0121,-2.8888},
				{0.0200,26.0244,-6.2853,4.4854,7.8885,9.3927,9.8179,4.7908,8.1200,7.0000,0.0000,5.0962,8.3515,4.6076,-9.8184,-2.8849},
				{0.0200,25.8647,-6.3275,4.6470,8.0802,9.5839,9.5603,4.9560,8.2600,7.0000,0.0000,5.2650,8.4398,4.4163,-9.5615,-2.8819},
				{0.0200,25.7023,-6.3708,4.8125,8.2756,9.7686,9.2350,5.1240,8.4000,7.0000,0.0000,5.4355,8.5244,4.2316,-9.2368,-2.8798},
				{0.0200,25.5374,-6.4151,4.9820,8.4745,9.9453,8.8340,5.2948,8.5400,7.0000,0.0000,5.6076,8.6055,4.0549,-8.8366,-2.8787},
				{0.0200,25.3698,-6.4603,5.1555,8.6767,10.1122,8.3458,5.4684,8.6800,7.0000,0.0000,5.7813,8.6833,3.8879,-8.3491,-2.8787},
				{0.0200,25.2048,-6.5046,5.3275,8.5991,-3.8818,-699.6999,5.6392,8.5400,-7.0000,0.0000,5.9509,8.4809,-10.1182,-700.3040,-2.8797},
				{0.0200,25.0425,-6.5479,5.4979,8.5181,-4.0474,-8.2764,5.8072,8.4000,-7.0000,0.0000,6.1165,8.2819,-9.9527,8.2730,-2.8816},
				{0.0200,24.8828,-6.5902,5.6665,8.4337,-4.2227,-8.7692,5.9724,8.2600,-7.0000,0.0000,6.2783,8.0863,-9.7774,8.7666,-2.8846},
				{0.0200,24.7257,-6.6312,5.8334,8.3456,-4.4062,-9.1737,6.1348,8.1200,-7.0000,0.0000,6.4361,7.8944,-9.5940,9.1718,-2.8884},
				{0.0200,24.5711,-6.6708,5.9985,8.2536,-4.5963,-9.5019,6.2944,7.9800,-7.0000,0.0000,6.5903,7.7063,-9.4040,9.5007,-2.8930},
				{0.0200,24.4190,-6.7090,6.1617,8.1578,-4.7915,-9.7620,6.4512,7.8400,-7.0000,0.0000,6.7407,7.5222,-9.2087,9.7614,-2.8983},
				{0.0200,24.2694,-6.7457,6.3228,8.0580,-4.9907,-9.9587,6.6052,7.7000,-7.0000,0.0000,6.8876,7.3420,-9.0096,9.9587,-2.9043},
				{0.0200,24.1223,-6.7807,6.4819,7.9541,-5.1925,-10.0941,6.7564,7.5600,-7.0000,0.0000,7.0309,7.1658,-8.8077,10.0946,-2.9109},
				{0.0200,23.9777,-6.8141,6.6388,7.8462,-5.3959,-10.1686,6.9048,7.4200,-7.0000,0.0000,7.1707,6.9937,-8.6043,10.1694,-2.9181},
				{0.0200,23.8356,-6.8459,6.7935,7.7342,-5.5995,-10.1811,7.0504,7.2800,-7.0000,0.0000,7.3073,6.8257,-8.4006,10.1823,-2.9257},
				{0.0200,23.6960,-6.8759,6.9459,7.6182,-5.8022,-10.1305,7.1932,7.1400,-7.0000,0.0000,7.4405,6.6618,-8.1980,10.1319,-2.9338},
				{0.0200,23.5589,-6.9042,7.0958,7.4981,-6.0025,-10.0153,7.3332,7.0000,-7.0000,0.0000,7.5705,6.5018,-7.9977,10.0168,-2.9421},
				{0.0200,23.4243,-6.9308,7.2433,7.3742,-6.1992,-9.8349,7.4704,6.8600,-7.0000,0.0000,7.6974,6.3458,-7.8009,9.8366,-2.9508},
				{0.0200,23.2923,-6.9557,7.3883,7.2463,-6.3909,-9.5896,7.6048,6.7200,-7.0000,0.0000,7.8213,6.1936,-7.6091,9.5913,-2.9596},
				{0.0200,23.1627,-6.9790,7.5306,7.1148,-6.5766,-9.2808,7.7364,6.5800,-7.0000,0.0000,7.9422,6.0451,-7.4235,9.2824,-2.9686},
				{0.0200,23.0358,-7.0006,7.6701,6.9797,-6.7548,-8.9114,7.8652,6.4400,-7.0000,0.0000,8.0602,5.9002,-7.2452,8.9129,-2.9777},
				{0.0200,22.9114,-7.0206,7.8070,6.8412,-6.9245,-8.4855,7.9912,6.3000,-7.0000,0.0000,8.1754,5.7587,-7.0755,8.4869,-2.9868},
				{0.0200,22.7895,-7.0390,7.9410,6.6995,-7.0847,-8.0086,8.1144,6.1600,-7.0000,0.0000,8.2878,5.6204,-6.9153,8.0099,-2.9959},
				{0.0200,22.6703,-7.0560,8.0721,6.5548,-7.2344,-7.4873,8.2348,6.0200,-7.0000,0.0000,8.3975,5.4851,-6.7655,7.4884,-3.0048},
				{0.0200,22.5538,-7.0715,8.2002,6.4074,-7.3730,-6.9291,8.3524,5.8800,-7.0000,0.0000,8.5046,5.3526,-6.6269,6.9300,-3.0137},
				{0.0200,22.4398,-7.0856,8.3254,6.2574,-7.4998,-6.3420,8.4672,5.7400,-7.0000,0.0000,8.6090,5.2226,-6.5000,6.3428,-3.0224},
				{0.0200,22.3286,-7.0985,8.4475,6.1051,-7.6145,-5.7344,8.5792,5.6000,-7.0000,0.0000,8.7109,5.0949,-6.3853,5.7349,-3.0309},
				{0.0200,22.2200,-7.1101,8.5665,5.9508,-7.7168,-5.1145,8.6884,5.4600,-7.0000,0.0000,8.8103,4.9692,-6.2830,5.1148,-3.0391},
				{0.0200,22.1141,-7.1205,8.6824,5.7946,-7.8066,-4.4903,8.7948,5.3200,-7.0000,0.0000,8.9072,4.8453,-6.1932,4.4905,-3.0471},
				{0.0200,22.0109,-7.1299,8.7951,5.6369,-7.8840,-3.8696,8.8984,5.1800,-7.0000,0.0000,9.0017,4.7230,-6.1158,3.8696,-3.0548},
				{0.0200,21.9105,-7.1383,8.9047,5.4780,-7.9492,-3.2591,8.9992,5.0400,-7.0000,0.0000,9.0937,4.6020,-6.0507,3.2589,-3.0622},
				{0.0200,21.8128,-7.1457,9.0110,5.3179,-8.0025,-2.6648,9.0972,4.9000,-7.0000,0.0000,9.1833,4.4821,-5.9974,2.6646,-3.0692},
				{0.0200,21.7178,-7.1523,9.1142,5.1570,-8.0443,-2.0921,9.1924,4.7600,-7.0000,0.0000,9.2706,4.3630,-5.9555,2.0917,-3.0759},
				{0.0200,21.6256,-7.1581,9.2141,4.9955,-8.0752,-1.5451,9.2848,4.6200,-7.0000,0.0000,9.3555,4.2445,-5.9246,1.5447,-3.0822},
				{0.0200,21.5361,-7.1631,9.3107,4.8336,-8.0958,-1.0273,9.3744,4.4800,-7.0000,0.0000,9.4380,4.1264,-5.9041,1.0268,-3.0881},
				{0.0200,21.4494,-7.1675,9.4042,4.6715,-8.1066,-0.5412,9.4612,4.3400,-7.0000,0.0000,9.5182,4.0085,-5.8933,0.5407,-3.0937},
				{0.0200,21.3655,-7.1713,9.4944,4.5093,-8.1084,-0.0887,9.5452,4.2000,-7.0000,0.0000,9.5960,3.8907,-5.8915,0.0882,-3.0989},
				{0.0200,21.2844,-7.1746,9.5813,4.3473,-8.1018,0.3290,9.6264,4.0600,-7.0000,0.0000,9.6715,3.7727,-5.8981,-0.3295,-3.1037},
				{0.0200,21.2060,-7.1774,9.6650,4.1855,-8.0876,0.7115,9.7048,3.9200,-7.0000,0.0000,9.7445,3.6545,-5.9124,-0.7120,-3.1082},
				{0.0200,21.1305,-7.1797,9.7455,4.0242,-8.0664,1.0585,9.7804,3.7800,-7.0000,0.0000,9.8153,3.5358,-5.9335,-1.0590,-3.1123},
				{0.0200,21.0577,-7.1817,9.8228,3.8634,-8.0390,1.3704,9.8532,3.6400,-7.0000,0.0000,9.8836,3.4166,-5.9610,-1.3708,-3.1160},
				{0.0200,20.9877,-7.1834,9.8968,3.7033,-8.0060,1.6476,9.9232,3.5000,-7.0000,0.0000,9.9495,3.2967,-5.9939,-1.6480,-3.1195},
				{0.0200,20.9205,-7.1848,9.9677,3.5439,-7.9682,1.8910,9.9904,3.3600,-7.0000,0.0000,10.0130,3.1761,-6.0317,-1.8913,-3.1225},
				{0.0200,20.8561,-7.1859,10.0354,3.3854,-7.9262,2.1013,10.0548,3.2200,-7.0000,0.0000,10.0741,3.0546,-6.0738,-2.1016,-3.1253},
				{0.0200,20.7946,-7.1868,10.1000,3.2278,-7.8806,2.2795,10.1164,3.0800,-7.0000,0.0000,10.1328,2.9322,-6.1194,-2.2798,-3.1278},
				{0.0200,20.7358,-7.1876,10.1614,3.0711,-7.8321,2.4266,10.1752,2.9400,-7.0000,0.0000,10.1890,2.8088,-6.1679,-2.4269,-3.1300},
				{0.0200,20.6798,-7.1882,10.2197,2.9155,-7.7812,2.5437,10.2312,2.8000,-7.0000,0.0000,10.2427,2.6845,-6.2188,-2.5439,-3.1320},
				{0.0200,20.6266,-7.1887,10.2749,2.7610,-7.7286,2.6318,10.2844,2.6600,-7.0000,0.0000,10.2938,2.5590,-6.2714,-2.6320,-3.1337},
				{0.0200,20.5762,-7.1890,10.3271,2.6075,-7.6747,2.6918,10.3348,2.5200,-7.0000,0.0000,10.3425,2.4325,-6.3253,-2.6920,-3.1351},
				{0.0200,20.5286,-7.1893,10.3762,2.4551,-7.6202,2.7248,10.3824,2.3800,-7.0000,0.0000,10.3886,2.3049,-6.3798,-2.7250,-3.1364},
				{0.0200,20.4838,-7.1895,10.4223,2.3037,-7.5656,2.7318,10.4272,2.2400,-7.0000,0.0000,10.4321,2.1763,-6.4344,-2.7319,-3.1375},
				{0.0200,20.4418,-7.1897,10.4653,2.1535,-7.5113,2.7138,10.4692,2.1000,-7.0000,0.0000,10.4730,2.0465,-6.4887,-2.7138,-3.1384},
				{0.0200,20.4026,-7.1898,10.5054,2.0044,-7.4579,2.6717,10.5084,1.9600,-7.0000,0.0000,10.5114,1.9156,-6.5421,-2.6717,-3.1391},
				{0.0200,20.3662,-7.1898,10.5425,1.8562,-7.4058,2.6066,10.5448,1.8200,-7.0000,0.0000,10.5470,1.7838,-6.5942,-2.6066,-3.1397},
				{0.0200,20.3326,-7.1899,10.5767,1.7091,-7.3554,2.5196,10.5784,1.6800,-7.0000,0.0000,10.5800,1.6509,-6.6446,-2.5196,-3.1402},
				{0.0200,20.3018,-7.1899,10.6080,1.5630,-7.3071,2.4117,10.6092,1.5400,-7.0000,0.0000,10.6104,1.5170,-6.6929,-2.4118,-3.1406},
				{0.0200,20.2738,-7.1900,10.6363,1.4178,-7.2614,2.2843,10.6372,1.4000,-7.0000,0.0000,10.6380,1.3822,-6.7386,-2.2843,-3.1409},
				{0.0200,20.2486,-7.1900,10.6618,1.2734,-7.2187,2.1385,10.6624,1.2600,-7.0000,0.0000,10.6630,1.2466,-6.7813,-2.1385,-3.1411},
				{0.0200,20.2262,-7.1900,10.6844,1.1298,-7.1792,1.9756,10.6848,1.1200,-7.0000,0.0000,10.6852,1.1102,-6.8208,-1.9756,-3.1413},
				{0.0200,20.2066,-7.1900,10.7041,0.9869,-7.1432,1.7971,10.7044,0.9800,-7.0000,0.0000,10.7046,0.9731,-6.8568,-1.7971,-3.1414},
				{0.0200,20.1898,-7.1900,10.7210,0.8447,-7.1111,1.6045,10.7212,0.8400,-7.0000,0.0000,10.7213,0.8353,-6.8889,-1.6045,-3.1415},
				{0.0200,20.1758,-7.1900,10.7351,0.7031,-7.0831,1.3993,10.7352,0.7000,-7.0000,0.0000,10.7353,0.6969,-6.9169,-1.3993,-3.1415},
				{0.0200,20.1646,-7.1900,10.7463,0.5619,-7.0595,1.1831,10.7464,0.5600,-7.0000,0.0000,10.7464,0.5581,-6.9405,-1.1831,-3.1416},
				{0.0200,20.1562,-7.1900,10.7548,0.4211,-7.0403,0.9577,10.7548,0.4200,-7.0000,0.0000,10.7548,0.4189,-6.9597,-0.9577,-3.1416},
				{0.0200,20.1506,-7.1900,10.7604,0.2805,-7.0258,0.7249,10.7604,0.2800,-7.0000,0.0000,10.7604,0.2795,-6.9742,-0.7249,-3.1416},
				{0.0200,20.1478,-7.1900,10.7632,0.1402,-7.0161,0.4864,10.7632,0.1400,-7.0000,0.0000,10.7632,0.1398,-6.9839,-0.4864,-3.1416},
				{0.0200,20.1478,-7.1900,10.7632,0.0000,-7.0112,0.2442,10.7632,0.0000,-7.0000,0.0000,10.7632,0.0000,-6.9888,-0.2442,-3.1416},
				{0.0200,20.1506,-7.1900,10.7660,0.1402,7.0112,701.1217,10.7604,-0.1400,-7.0000,0.0000,10.7660,0.1398,6.9888,698.8783,-3.1416},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}