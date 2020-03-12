package frc.paths;

import com.team319.trajectory.Path;

public class Trench8BallReverse extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,23.6580,-7.8300,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,-3.1208},
				{0.0200,23.6540,-7.8301,0.0060,0.1999,4.9964,-0.1792,0.0060,0.2000,5.0000,0.0000,0.0060,0.2001,5.0036,0.1792,-3.1208},
				{0.0200,23.6480,-7.8302,0.0120,0.2998,4.9915,-0.2457,0.0120,0.3000,5.0000,0.0000,0.0120,0.3002,5.0085,0.2457,-3.1208},
				{0.0200,23.6400,-7.8304,0.0200,0.3994,4.9835,-0.4007,0.0200,0.4000,5.0000,0.0000,0.0200,0.4006,5.0165,0.4007,-3.1207},
				{0.0200,23.6300,-7.8306,0.0300,0.4989,4.9729,-0.5316,0.0300,0.5000,5.0000,0.0000,0.0300,0.5011,5.0271,0.5316,-3.1207},
				{0.0200,23.6180,-7.8309,0.0419,0.5981,4.9597,-0.6600,0.0420,0.6000,5.0000,0.0000,0.0421,0.6019,5.0403,0.6600,-3.1207},
				{0.0200,23.6040,-7.8312,0.0559,0.6970,4.9439,-0.7857,0.0560,0.7000,5.0000,0.0000,0.0561,0.7030,5.0561,0.7857,-3.1206},
				{0.0200,23.5880,-7.8315,0.0718,0.7955,4.9258,-0.9079,0.0720,0.8000,5.0000,0.0000,0.0722,0.8045,5.0742,0.9079,-3.1206},
				{0.0200,23.5700,-7.8319,0.0896,0.8936,4.9053,-1.0262,0.0900,0.9000,5.0000,0.0000,0.0904,0.9064,5.0947,1.0262,-3.1205},
				{0.0200,23.5500,-7.8323,0.1095,0.9912,4.8825,-1.1401,0.1100,1.0000,5.0000,0.0000,0.1105,1.0088,5.1175,1.1401,-3.1203},
				{0.0200,23.5280,-7.8328,0.1312,1.0884,4.8575,-1.2491,0.1320,1.1000,5.0000,0.0000,0.1328,1.1116,5.1425,1.2491,-3.1201},
				{0.0200,23.5040,-7.8333,0.1549,1.1850,4.8304,-1.3530,0.1560,1.2000,5.0000,0.0000,0.1571,1.2150,5.1696,1.3529,-3.1199},
				{0.0200,23.4780,-7.8339,0.1806,1.2810,4.8014,-1.4511,0.1820,1.3000,5.0000,0.0000,0.1834,1.3190,5.1986,1.4511,-3.1195},
				{0.0200,23.4500,-7.8345,0.2081,1.3764,4.7705,-1.5433,0.2100,1.4000,5.0000,0.0000,0.2119,1.4236,5.2295,1.5433,-3.1192},
				{0.0200,23.4201,-7.8352,0.2375,1.4712,4.7379,-1.6291,0.2400,1.5000,5.0000,0.0000,0.2425,1.5288,5.2621,1.6291,-3.1187},
				{0.0200,23.3881,-7.8359,0.2688,1.5653,4.7038,-1.7083,0.2720,1.6000,5.0000,0.0000,0.2752,1.6347,5.2962,1.7082,-3.1181},
				{0.0200,23.3541,-7.8367,0.3020,1.6586,4.6682,-1.7805,0.3060,1.7000,5.0000,0.0000,0.3100,1.7414,5.3318,1.7805,-3.1174},
				{0.0200,23.3181,-7.8376,0.3370,1.7512,4.6313,-1.8456,0.3420,1.8000,5.0000,0.0000,0.3470,1.8488,5.3687,1.8456,-3.1166},
				{0.0200,23.2801,-7.8386,0.3739,1.8431,4.5932,-1.9032,0.3800,1.9000,5.0000,0.0000,0.3861,1.9569,5.4068,1.9032,-3.1156},
				{0.0200,23.2401,-7.8396,0.4126,1.9342,4.5541,-1.9532,0.4200,2.0000,5.0000,0.0000,0.4274,2.0658,5.4459,1.9531,-3.1145},
				{0.0200,23.1981,-7.8408,0.4530,2.0245,4.5142,-1.9952,0.4620,2.1000,5.0000,0.0000,0.4710,2.1755,5.4858,1.9951,-3.1132},
				{0.0200,23.1541,-7.8421,0.4953,2.1140,4.4736,-2.0291,0.5060,2.2000,5.0000,0.0000,0.5167,2.2860,5.5263,2.0290,-3.1118},
				{0.0200,23.1082,-7.8435,0.5394,2.2026,4.4326,-2.0545,0.5520,2.3000,5.0000,0.0000,0.5646,2.3974,5.5674,2.0544,-3.1102},
				{0.0200,23.0602,-7.8450,0.5852,2.2904,4.3911,-2.0712,0.6000,2.4000,5.0000,0.0000,0.6148,2.5096,5.6089,2.0711,-3.1083},
				{0.0200,23.0102,-7.8468,0.6327,2.3774,4.3496,-2.0788,0.6500,2.5000,5.0000,0.0000,0.6673,2.6226,5.6504,2.0787,-3.1063},
				{0.0200,22.9583,-7.8487,0.6820,2.4636,4.3080,-2.0770,0.7020,2.6000,5.0000,0.0000,0.7220,2.7364,5.6920,2.0769,-3.1040},
				{0.0200,22.9043,-7.8508,0.7330,2.5489,4.2667,-2.0654,0.7560,2.7000,5.0000,0.0000,0.7790,2.8511,5.7333,2.0653,-3.1014},
				{0.0200,22.8483,-7.8531,0.7857,2.6334,4.2258,-2.0434,0.8120,2.8000,5.0000,0.0000,0.8383,2.9666,5.7741,2.0433,-3.0986},
				{0.0200,22.7904,-7.8557,0.8400,2.7171,4.1856,-2.0106,0.8700,2.9000,5.0000,0.0000,0.9000,3.0829,5.8143,2.0104,-3.0955},
				{0.0200,22.7305,-7.8585,0.8960,2.8001,4.1463,-1.9662,0.9300,3.0000,5.0000,0.0000,0.9640,3.1999,5.8537,1.9660,-3.0922},
				{0.0200,22.6686,-7.8617,0.9536,2.8822,4.1081,-1.9095,0.9920,3.1000,5.0000,0.0000,1.0304,3.3178,5.8919,1.9093,-3.0885},
				{0.0200,22.6046,-7.8652,1.0129,2.9637,4.0713,-1.8398,1.0560,3.2000,5.0000,0.0000,1.0991,3.4363,5.9286,1.8396,-3.0846},
				{0.0200,22.5388,-7.8691,1.0738,3.0444,4.0362,-1.7562,1.1220,3.3000,5.0000,0.0000,1.1702,3.5556,5.9638,1.7559,-3.0803},
				{0.0200,22.4709,-7.8734,1.1363,3.1244,4.0030,-1.6577,1.1900,3.4000,5.0000,0.0000,1.2437,3.6756,5.9969,1.6574,-3.0756},
				{0.0200,22.4011,-7.8782,1.2004,3.2039,3.9722,-1.5433,1.2600,3.5000,5.0000,0.0000,1.3196,3.7961,6.0278,1.5429,-3.0706},
				{0.0200,22.3293,-7.8835,1.2660,3.2828,3.9439,-1.4118,1.3320,3.6000,5.0000,0.0000,1.3980,3.9172,6.0560,1.4115,-3.0653},
				{0.0200,22.2555,-7.8894,1.3332,3.3611,3.9187,-1.2623,1.4060,3.7000,5.0000,0.0000,1.4788,4.0389,6.0812,1.2619,-3.0596},
				{0.0200,22.1798,-7.8958,1.4020,3.4391,3.8968,-1.0935,1.4820,3.8000,5.0000,0.0000,1.5620,4.1609,6.1031,1.0930,-3.0536},
				{0.0200,22.1021,-7.9029,1.4724,3.5166,3.8787,-0.9043,1.5600,3.9000,5.0000,0.0000,1.6476,4.2833,6.1212,0.9038,-3.0471},
				{0.0200,22.0225,-7.9107,1.5442,3.5939,3.8649,-0.6938,1.6400,4.0000,5.0000,0.0000,1.7358,4.4060,6.1350,0.6933,-3.0403},
				{0.0200,21.9409,-7.9193,1.6177,3.6711,3.8556,-0.4609,1.7220,4.1000,5.0000,0.0000,1.8263,4.5289,6.1442,0.4604,-3.0331},
				{0.0200,21.8575,-7.9287,1.6926,3.7481,3.8515,-0.2050,1.8060,4.2000,5.0000,0.0000,1.9194,4.6519,6.1483,0.2045,-3.0255},
				{0.0200,21.7721,-7.9390,1.7691,3.8251,3.8530,0.0745,1.8920,4.3000,5.0000,0.0000,2.0149,4.7748,6.1468,-0.0750,-3.0175},
				{0.0200,21.6848,-7.9503,1.8472,3.9024,3.8606,0.3777,1.9800,4.4000,5.0000,0.0000,2.1128,4.8976,6.1393,-0.3782,-3.0091},
				{0.0200,21.5956,-7.9626,1.9268,3.9799,3.8747,0.7046,2.0700,4.5000,5.0000,0.0000,2.2132,5.0201,6.1252,-0.7051,-3.0004},
				{0.0200,21.5046,-7.9759,2.0079,4.0578,3.8958,1.0544,2.1620,4.6000,5.0000,0.0000,2.3161,5.1422,6.1041,-1.0548,-2.9913},
				{0.0200,21.4117,-7.9904,2.0906,4.1363,3.9243,1.4261,2.2560,4.7000,5.0000,0.0000,2.4213,5.2637,6.0755,-1.4264,-2.9818},
				{0.0200,21.3170,-8.0062,2.1750,4.2155,3.9606,1.8178,2.3520,4.8000,5.0000,0.0000,2.5290,5.3845,6.0392,-1.8181,-2.9720},
				{0.0200,21.2205,-8.0232,2.2609,4.2956,4.0052,2.2273,2.4500,4.9000,5.0000,0.0000,2.6391,5.5044,5.9946,-2.2275,-2.9618},
				{0.0200,21.1222,-8.0416,2.3484,4.3767,4.0582,2.6514,2.5500,5.0000,5.0000,0.0000,2.7516,5.6232,5.9416,-2.6516,-2.9514},
				{0.0200,21.0222,-8.0614,2.4376,4.4591,4.1200,3.0866,2.6520,5.1000,5.0000,0.0000,2.8664,5.7408,5.8799,-3.0866,-2.9406},
				{0.0200,20.9204,-8.0828,2.5284,4.5429,4.1905,3.5285,2.7560,5.2000,5.0000,0.0000,2.9835,5.8570,5.8093,-3.5284,-2.9295},
				{0.0200,20.8169,-8.1057,2.6210,4.6283,4.2700,3.9721,2.8620,5.3000,5.0000,0.0000,3.1030,5.9716,5.7299,-3.9718,-2.9183},
				{0.0200,20.7117,-8.1302,2.7153,4.7155,4.3582,4.4120,2.9700,5.4000,5.0000,0.0000,3.2247,6.0844,5.6416,-4.4115,-2.9068},
				{0.0200,20.6049,-8.1564,2.8114,4.8046,4.4551,4.8423,3.0800,5.5000,5.0000,0.0000,3.3486,6.1953,5.5448,-4.8417,-2.8951},
				{0.0200,20.4964,-8.1844,2.9093,4.8958,4.5602,5.2570,3.1920,5.6000,5.0000,0.0000,3.4747,6.3041,5.4397,-5.2563,-2.8832},
				{0.0200,20.3864,-8.2142,3.0091,4.9893,4.6732,5.6501,3.3060,5.7000,5.0000,0.0000,3.6029,6.4107,5.3267,-5.6492,-2.8713},
				{0.0200,20.2748,-8.2458,3.1108,5.0851,4.7935,6.0157,3.4220,5.8000,5.0000,0.0000,3.7332,6.5148,5.2064,-6.0147,-2.8593},
				{0.0200,20.1617,-8.2794,3.2145,5.1836,4.9205,6.3484,3.5400,5.9000,5.0000,0.0000,3.8655,6.6164,5.0794,-6.3472,-2.8472},
				{0.0200,20.0471,-8.3149,3.3202,5.2846,5.0533,6.6434,3.6600,6.0000,5.0000,0.0000,3.9998,6.7153,4.9466,-6.6420,-2.8352},
				{0.0200,19.9310,-8.3524,3.4280,5.3885,5.1913,6.8967,3.7820,6.1000,5.0000,0.0000,4.1360,6.8115,4.8087,-6.8952,-2.8233},
				{0.0200,19.8134,-8.3919,3.5379,5.4951,5.3334,7.1055,3.9060,6.2000,5.0000,0.0000,4.2741,6.9048,4.6666,-7.1040,-2.8114},
				{0.0200,19.6945,-8.4334,3.6499,5.6047,5.4787,7.2681,4.0320,6.3000,5.0000,0.0000,4.4140,6.9952,4.5213,-7.2665,-2.7997},
				{0.0200,19.5741,-8.4770,3.7643,5.7172,5.6264,7.3841,4.1600,6.4000,5.0000,0.0000,4.5557,7.0827,4.3736,-7.3825,-2.7882},
				{0.0200,19.4524,-8.5227,3.8809,5.8327,5.7755,7.4545,4.2900,6.5000,5.0000,0.0000,4.6990,7.1672,4.2246,-7.4529,-2.7770},
				{0.0200,19.3294,-8.5704,4.0000,5.9512,5.9251,7.4814,4.4220,6.6000,5.0000,0.0000,4.8440,7.2487,4.0750,-7.4798,-2.7661},
				{0.0200,19.2050,-8.6202,4.1214,6.0727,6.0745,7.4682,4.5560,6.7000,5.0000,0.0000,4.9905,7.3272,3.9257,-7.4667,-2.7556},
				{0.0200,19.0792,-8.6721,4.2454,6.1972,6.2229,7.4193,4.6920,6.8000,5.0000,0.0000,5.1386,7.4028,3.7773,-7.4179,-2.7455},
				{0.0200,18.9522,-8.7260,4.3719,6.3246,6.3697,7.3399,4.8300,6.9000,5.0000,0.0000,5.2881,7.4754,3.6305,-7.3387,-2.7358},
				{0.0200,18.8238,-8.7818,4.5010,6.4549,6.5144,7.2359,4.9700,7.0000,5.0000,0.0000,5.4390,7.5451,3.4858,-7.2349,-2.7266},
				{0.0200,18.6941,-8.8396,4.6327,6.5880,6.6567,7.1135,5.1120,7.1000,5.0000,0.0000,5.5912,7.6120,3.3436,-7.1126,-2.7180},
				{0.0200,18.5631,-8.8994,4.7672,6.7239,6.7963,6.9787,5.2560,7.2000,5.0000,0.0000,5.7448,7.6760,3.2040,-6.9781,-2.7100},
				{0.0200,18.4307,-8.9609,4.9044,6.8626,6.9330,6.8376,5.4020,7.3000,5.0000,0.0000,5.8995,7.7374,3.0673,-6.8373,-2.7027},
				{0.0200,18.2969,-9.0243,5.0445,7.0039,7.0669,6.6957,5.5500,7.4000,5.0000,0.0000,6.0554,7.7960,2.9334,-6.6956,-2.6960},
				{0.0200,18.1618,-9.0893,5.1875,7.1479,7.1981,6.5576,5.7000,7.5000,5.0000,0.0000,6.2125,7.8521,2.8022,-6.5579,-2.6901},
				{0.0200,18.0252,-9.1560,5.3334,7.2944,7.3266,6.4270,5.8520,7.6000,5.0000,0.0000,6.3706,7.9056,2.6736,-6.4277,-2.6850},
				{0.0200,17.8871,-9.2242,5.4822,7.4435,7.4527,6.3065,6.0060,7.7000,5.0000,0.0000,6.5297,7.9565,2.5475,-6.3075,-2.6806},
				{0.0200,17.7475,-9.2939,5.6341,7.5950,7.5767,6.1969,6.1620,7.8000,5.0000,0.0000,6.6898,8.0050,2.4235,-6.1983,-2.6772},
				{0.0200,17.6063,-9.3648,5.7891,7.7490,7.6986,6.0975,6.3200,7.9000,5.0000,0.0000,6.8508,8.0510,2.3015,-6.0993,-2.6747},
				{0.0200,17.4635,-9.4370,5.9472,7.9054,7.8187,6.0056,6.4800,8.0000,5.0000,0.0000,7.0127,8.0946,2.1814,-6.0079,-2.6731},
				{0.0200,17.3190,-9.5102,6.1085,8.0641,7.9371,5.9163,6.6420,8.1000,5.0000,0.0000,7.1755,8.1359,2.0630,-5.9191,-2.6725},
				{0.0200,17.1727,-9.5843,6.2730,8.2252,8.0535,5.8222,6.8060,8.2000,5.0000,0.0000,7.3389,8.1748,1.9465,-5.8255,-2.6729},
				{0.0200,17.0282,-9.6574,6.4367,8.1856,-1.9761,-501.4829,6.9680,8.1000,-5.0000,0.0000,7.4992,8.0144,-8.0239,-498.5206,-2.6743},
				{0.0200,16.8852,-9.7293,6.5996,8.1438,-2.0907,-5.7277,7.1280,8.0000,-5.0000,0.0000,7.6564,7.8562,-7.9094,5.7246,-2.6767},
				{0.0200,16.7439,-9.7999,6.7616,8.0997,-2.2075,-5.8394,7.2860,7.9000,-5.0000,0.0000,7.8104,7.7003,-7.7927,5.8369,-2.6801},
				{0.0200,16.6041,-9.8691,6.9227,8.0531,-2.3265,-5.9517,7.4420,7.8000,-5.0000,0.0000,7.9613,7.5468,-7.6737,5.9496,-2.6844},
				{0.0200,16.4657,-9.9367,7.0827,8.0042,-2.4479,-6.0707,7.5960,7.7000,-5.0000,0.0000,8.1092,7.3958,-7.5523,6.0690,-2.6895},
				{0.0200,16.3288,-10.0027,7.2418,7.9528,-2.5719,-6.2001,7.7480,7.6000,-5.0000,0.0000,8.2542,7.2472,-7.4283,6.1989,-2.6954},
				{0.0200,16.1933,-10.0670,7.3998,7.8988,-2.6988,-6.3415,7.8980,7.5000,-5.0000,0.0000,8.3962,7.1012,-7.3015,6.3407,-2.7021},
				{0.0200,16.0591,-10.1295,7.5566,7.8422,-2.8287,-6.4947,8.0460,7.4000,-5.0000,0.0000,8.5353,6.9578,-7.1716,6.4943,-2.7095},
				{0.0200,15.9263,-10.1901,7.7123,7.7830,-2.9618,-6.6577,8.1920,7.3000,-5.0000,0.0000,8.6717,6.8170,-7.0385,6.6576,-2.7177},
				{0.0200,15.7948,-10.2488,7.8667,7.7210,-3.0984,-6.8270,8.3360,7.2000,-5.0000,0.0000,8.8053,6.6790,-6.9019,6.8273,-2.7264},
				{0.0200,15.6646,-10.3055,8.0198,7.6562,-3.2383,-6.9981,8.4780,7.1000,-5.0000,0.0000,8.9361,6.5437,-6.7620,6.9986,-2.7358},
				{0.0200,15.5357,-10.3601,8.1716,7.5886,-3.3816,-7.1651,8.6180,7.0000,-5.0000,0.0000,9.0644,6.4113,-6.6187,7.1659,-2.7456},
				{0.0200,15.4081,-10.4127,8.3220,7.5180,-3.5281,-7.3219,8.7560,6.9000,-5.0000,0.0000,9.1900,6.2819,-6.4722,7.3230,-2.7560},
				{0.0200,15.2818,-10.4631,8.4708,7.4445,-3.6773,-7.4617,8.8920,6.8000,-5.0000,0.0000,9.3131,6.1554,-6.3229,7.4629,-2.7669},
				{0.0200,15.1568,-10.5115,8.6182,7.3679,-3.8288,-7.5776,9.0260,6.7000,-5.0000,0.0000,9.4337,6.0320,-6.1714,7.5790,-2.7781},
				{0.0200,15.0332,-10.5577,8.7640,7.2883,-3.9821,-7.6631,9.1580,6.6000,-5.0000,0.0000,9.5520,5.9117,-6.0181,7.6646,-2.7897},
				{0.0200,14.9109,-10.6018,8.9081,7.2055,-4.1363,-7.7119,9.2880,6.5000,-5.0000,0.0000,9.6679,5.7944,-5.8638,7.7136,-2.8015},
				{0.0200,14.7900,-10.6438,9.0505,7.1197,-4.2907,-7.7189,9.4160,6.4000,-5.0000,0.0000,9.7815,5.6802,-5.7094,7.7206,-2.8136},
				{0.0200,14.6704,-10.6836,9.1911,7.0308,-4.4443,-7.6796,9.5420,6.3000,-5.0000,0.0000,9.8929,5.5691,-5.5557,7.6814,-2.8259},
				{0.0200,14.5523,-10.7214,9.3299,6.9389,-4.5961,-7.5911,9.6660,6.2000,-5.0000,0.0000,10.0021,5.4610,-5.4039,7.5929,-2.8383},
				{0.0200,14.4357,-10.7571,9.4668,6.8440,-4.7452,-7.4518,9.7880,6.1000,-5.0000,0.0000,10.1092,5.3559,-5.2548,7.4535,-2.8508},
				{0.0200,14.3205,-10.7908,9.6017,6.7462,-4.8904,-7.2613,9.9080,6.0000,-5.0000,0.0000,10.2143,5.2537,-5.1096,7.2629,-2.8634},
				{0.0200,14.2068,-10.8225,9.7346,6.6456,-5.0308,-7.0211,10.0260,5.9000,-5.0000,0.0000,10.3174,5.1543,-4.9691,7.0226,-2.8759},
				{0.0200,14.0947,-10.8522,9.8654,6.5423,-5.1655,-6.7338,10.1420,5.8000,-5.0000,0.0000,10.4185,5.0576,-4.8344,6.7351,-2.8884},
				{0.0200,13.9842,-10.8801,9.9942,6.4364,-5.2936,-6.4032,10.2560,5.7000,-5.0000,0.0000,10.5178,4.9635,-4.7063,6.4044,-2.9008},
				{0.0200,13.8752,-10.9062,10.1207,6.3281,-5.4142,-6.0343,10.3680,5.6000,-5.0000,0.0000,10.6152,4.8718,-4.5856,6.0354,-2.9130},
				{0.0200,13.7680,-10.9305,10.2451,6.2176,-5.5269,-5.6330,10.4780,5.5000,-5.0000,0.0000,10.7109,4.7823,-4.4729,5.6339,-2.9251},
				{0.0200,13.6623,-10.9530,10.3672,6.1050,-5.6310,-5.2056,10.5860,5.4000,-5.0000,0.0000,10.8048,4.6950,-4.3688,5.2063,-2.9369},
				{0.0200,13.5584,-10.9740,10.4870,5.9904,-5.7262,-4.7587,10.6920,5.3000,-5.0000,0.0000,10.8969,4.6095,-4.2736,4.7592,-2.9485},
				{0.0200,13.4563,-10.9934,10.6045,5.8742,-5.8122,-4.2990,10.7960,5.2000,-5.0000,0.0000,10.9875,4.5257,-4.1876,4.2994,-2.9598},
				{0.0200,13.3558,-11.0112,10.7196,5.7564,-5.8888,-3.8332,10.8980,5.1000,-5.0000,0.0000,11.0763,4.4435,-4.1110,3.8334,-2.9709},
				{0.0200,13.2572,-11.0277,10.8323,5.6373,-5.9562,-3.3674,10.9980,5.0000,-5.0000,0.0000,11.1636,4.3626,-4.0436,3.3674,-2.9816},
				{0.0200,13.1604,-11.0428,10.9427,5.5170,-6.0143,-2.9071,11.0960,4.9000,-5.0000,0.0000,11.2492,4.2829,-3.9855,2.9070,-2.9920},
				{0.0200,13.0654,-11.0566,11.0506,5.3957,-6.0635,-2.4575,11.1920,4.8000,-5.0000,0.0000,11.3333,4.2042,-3.9363,2.4573,-3.0020},
				{0.0200,12.9722,-11.0693,11.1561,5.2737,-6.1039,-2.0227,11.2860,4.7000,-5.0000,0.0000,11.4159,4.1263,-3.8959,2.0224,-3.0116},
				{0.0200,12.8810,-11.0808,11.2591,5.1509,-6.1361,-1.6063,11.3780,4.6000,-5.0000,0.0000,11.4968,4.0490,-3.8638,1.6059,-3.0209},
				{0.0200,12.7916,-11.0912,11.3596,5.0277,-6.1603,-1.2111,11.4680,4.5000,-5.0000,0.0000,11.5763,3.9722,-3.8396,1.2106,-3.0297},
				{0.0200,12.7041,-11.1007,11.4577,4.9042,-6.1771,-0.8390,11.5560,4.4000,-5.0000,0.0000,11.6542,3.8958,-3.8228,0.8385,-3.0382},
				{0.0200,12.6185,-11.1092,11.5533,4.7805,-6.1869,-0.4915,11.6420,4.3000,-5.0000,0.0000,11.7306,3.8195,-3.8130,0.4909,-3.0463},
				{0.0200,12.5348,-11.1169,11.6465,4.6567,-6.1903,-0.1692,11.7260,4.2000,-5.0000,0.0000,11.8055,3.7433,-3.8096,0.1687,-3.0540},
				{0.0200,12.4531,-11.1237,11.7371,4.5329,-6.1877,0.1274,11.8080,4.1000,-5.0000,0.0000,11.8788,3.6671,-3.8122,-0.1280,-3.0612},
				{0.0200,12.3734,-11.1299,11.8253,4.4093,-6.1797,0.3988,11.8880,4.0000,-5.0000,0.0000,11.9506,3.5907,-3.8201,-0.3993,-3.0681},
				{0.0200,12.2956,-11.1354,11.9110,4.2860,-6.1668,0.6453,11.9660,3.9000,-5.0000,0.0000,12.0209,3.5140,-3.8331,-0.6458,-3.0746},
				{0.0200,12.2197,-11.1402,11.9943,4.1630,-6.1495,0.8679,12.0420,3.8000,-5.0000,0.0000,12.0896,3.4370,-3.8504,-0.8684,-3.0807},
				{0.0200,12.1458,-11.1445,12.0751,4.0404,-6.1281,1.0675,12.1160,3.7000,-5.0000,0.0000,12.1568,3.3596,-3.8718,-1.0680,-3.0864},
				{0.0200,12.0739,-11.1483,12.1535,3.9184,-6.1032,1.2454,12.1880,3.6000,-5.0000,0.0000,12.2225,3.2816,-3.8967,-1.2459,-3.0918},
				{0.0200,12.0040,-11.1516,12.2294,3.7969,-6.0752,1.4028,12.2580,3.5000,-5.0000,0.0000,12.2865,3.2031,-3.9248,-1.4033,-3.0968},
				{0.0200,11.9361,-11.1545,12.3029,3.6760,-6.0443,1.5410,12.3260,3.4000,-5.0000,0.0000,12.3490,3.1240,-3.9556,-1.5414,-3.1014},
				{0.0200,11.8701,-11.1570,12.3740,3.5557,-6.0111,1.6613,12.3920,3.3000,-5.0000,0.0000,12.4099,3.0443,-3.9888,-1.6617,-3.1057},
				{0.0200,11.8062,-11.1592,12.4428,3.4362,-5.9758,1.7650,12.4560,3.2000,-5.0000,0.0000,12.4692,2.9638,-4.0241,-1.7653,-3.1097},
				{0.0200,11.7442,-11.1610,12.5091,3.3175,-5.9388,1.8532,12.5180,3.1000,-5.0000,0.0000,12.5268,2.8825,-4.0612,-1.8535,-3.1133},
				{0.0200,11.6842,-11.1626,12.5731,3.1994,-5.9002,1.9269,12.5780,3.0000,-5.0000,0.0000,12.5828,2.8005,-4.0998,-1.9272,-3.1167},
				{0.0200,11.6262,-11.1640,12.6347,3.0822,-5.8605,1.9874,12.6360,2.9000,-5.0000,0.0000,12.6372,2.7178,-4.1395,-1.9876,-3.1197},
				{0.0200,11.5702,-11.1651,12.6941,2.9658,-5.8198,2.0353,12.6920,2.8000,-5.0000,0.0000,12.6899,2.6342,-4.1802,-2.0355,-3.1225},
				{0.0200,11.5163,-11.1661,12.7511,2.8503,-5.7783,2.0717,12.7460,2.7000,-5.0000,0.0000,12.7408,2.5497,-4.2217,-2.0719,-3.1251},
				{0.0200,11.4643,-11.1669,12.8058,2.7355,-5.7364,2.0971,12.7980,2.6000,-5.0000,0.0000,12.7901,2.4644,-4.2636,-2.0973,-3.1273},
				{0.0200,11.4143,-11.1675,12.8582,2.6217,-5.6941,2.1123,12.8480,2.5000,-5.0000,0.0000,12.8377,2.3783,-4.3058,-2.1124,-3.1294},
				{0.0200,11.3663,-11.1681,12.9084,2.5086,-5.6518,2.1177,12.8960,2.4000,-5.0000,0.0000,12.8835,2.2914,-4.3482,-2.1179,-3.1312},
				{0.0200,11.3203,-11.1685,12.9563,2.3964,-5.6095,2.1139,12.9420,2.3000,-5.0000,0.0000,12.9276,2.2036,-4.3905,-2.1140,-3.1328},
				{0.0200,11.2763,-11.1689,13.0020,2.2851,-5.5675,2.1012,12.9860,2.2000,-5.0000,0.0000,12.9699,2.1149,-4.4325,-2.1013,-3.1343},
				{0.0200,11.2343,-11.1691,13.0455,2.1746,-5.5259,2.0800,13.0280,2.1000,-5.0000,0.0000,13.0104,2.0254,-4.4741,-2.0801,-3.1355},
				{0.0200,11.1943,-11.1694,13.0868,2.0649,-5.4849,2.0506,13.0680,2.0000,-5.0000,0.0000,13.0491,1.9351,-4.5151,-2.0506,-3.1366},
				{0.0200,11.1563,-11.1695,13.1259,1.9560,-5.4446,2.0132,13.1060,1.9000,-5.0000,0.0000,13.0860,1.8440,-4.5554,-2.0132,-3.1375},
				{0.0200,11.1203,-11.1697,13.1629,1.8479,-5.4052,1.9680,13.1420,1.8000,-5.0000,0.0000,13.1210,1.7521,-4.5947,-1.9681,-3.1383},
				{0.0200,11.0863,-11.1698,13.1977,1.7405,-5.3669,1.9154,13.1760,1.7000,-5.0000,0.0000,13.1542,1.6595,-4.6331,-1.9154,-3.1390},
				{0.0200,11.0543,-11.1698,13.2304,1.6339,-5.3298,1.8554,13.2080,1.6000,-5.0000,0.0000,13.1855,1.5661,-4.6702,-1.8554,-3.1396},
				{0.0200,11.0243,-11.1699,13.2609,1.5281,-5.2941,1.7883,13.2380,1.5000,-5.0000,0.0000,13.2150,1.4719,-4.7059,-1.7884,-3.1401},
				{0.0200,10.9963,-11.1699,13.2894,1.4229,-5.2598,1.7144,13.2660,1.4000,-5.0000,0.0000,13.2425,1.3771,-4.7402,-1.7144,-3.1405},
				{0.0200,10.9703,-11.1700,13.3158,1.3183,-5.2271,1.6338,13.2920,1.3000,-5.0000,0.0000,13.2682,1.2817,-4.7729,-1.6338,-3.1408},
				{0.0200,10.9463,-11.1700,13.3400,1.2144,-5.1962,1.5468,13.3160,1.2000,-5.0000,0.0000,13.2919,1.1856,-4.8038,-1.5468,-3.1410},
				{0.0200,10.9243,-11.1700,13.3623,1.1111,-5.1671,1.4537,13.3380,1.1000,-5.0000,0.0000,13.3137,1.0889,-4.8329,-1.4537,-3.1412},
				{0.0200,10.9043,-11.1700,13.3824,1.0083,-5.1400,1.3548,13.3580,1.0000,-5.0000,0.0000,13.3335,0.9917,-4.8600,-1.3548,-3.1413},
				{0.0200,10.8863,-11.1700,13.4006,0.9060,-5.1150,1.2504,13.3760,0.9000,-5.0000,0.0000,13.3514,0.8940,-4.8850,-1.2504,-3.1414},
				{0.0200,10.8703,-11.1700,13.4166,0.8041,-5.0922,1.1408,13.3920,0.8000,-5.0000,0.0000,13.3673,0.7959,-4.9078,-1.1408,-3.1415},
				{0.0200,10.8563,-11.1700,13.4307,0.7027,-5.0716,1.0266,13.4060,0.7000,-5.0000,0.0000,13.3812,0.6973,-4.9284,-1.0266,-3.1415},
				{0.0200,10.8443,-11.1700,13.4427,0.6016,-5.0535,0.9080,13.4180,0.6000,-5.0000,0.0000,13.3932,0.5984,-4.9465,-0.9080,-3.1416},
				{0.0200,10.8343,-11.1700,13.4527,0.5009,-5.0378,0.7856,13.4280,0.5000,-5.0000,0.0000,13.4032,0.4991,-4.9622,-0.7856,-3.1416},
				{0.0200,10.8263,-11.1700,13.4607,0.4004,-5.0246,0.6599,13.4360,0.4000,-5.0000,0.0000,13.4112,0.3996,-4.9754,-0.6599,-3.1416},
				{0.0200,10.8203,-11.1700,13.4667,0.3001,-5.0139,0.5314,13.4420,0.3000,-5.0000,0.0000,13.4172,0.2999,-4.9861,-0.5314,-3.1416},
				{0.0200,10.8200,-11.1700,13.4670,0.0136,-14.3267,-465.6381,13.4423,0.2000,-5.0000,0.0000,13.4174,0.0136,-14.3180,-466.5947,-3.1416},
				{0.0200,10.8200,-11.1700,13.4670,0.0000,-0.6777,682.4511,13.4423,0.1000,-5.0000,0.0000,13.4174,0.0000,-0.6777,682.0144,-3.1416},
				{0.0200,10.8200,-11.1700,13.4670,0.0000,0.0000,33.8840,13.4423,-0.0000,-5.0000,0.0000,13.4174,0.0000,0.0000,33.8832,-3.1416},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}