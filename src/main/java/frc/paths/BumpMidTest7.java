package frc.paths;

import com.team319.trajectory.Path;

public class BumpMidTest7 extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,19.7919,-6.6993,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.3753},
				{0.0200,19.7956,-6.6978,0.0060,0.1997,4.9868,-0.6607,0.0060,0.2000,5.0000,0.0000,0.0060,0.2003,5.0132,0.6607,0.3753},
				{0.0200,19.8012,-6.6956,0.0120,0.2991,4.9687,-0.9052,0.0120,0.3000,5.0000,0.0000,0.0120,0.3009,5.0313,0.9052,0.3753},
				{0.0200,19.8086,-6.6927,0.0199,0.3979,4.9392,-1.4746,0.0200,0.4000,5.0000,0.0000,0.0201,0.4021,5.0608,1.4746,0.3753},
				{0.0200,19.8179,-6.6890,0.0299,0.4959,4.9001,-1.9530,0.0300,0.5000,5.0000,0.0000,0.0301,0.5041,5.0999,1.9530,0.3754},
				{0.0200,19.8291,-6.6846,0.0417,0.5929,4.8517,-2.4208,0.0420,0.6000,5.0000,0.0000,0.0423,0.6071,5.1483,2.4207,0.3755},
				{0.0200,19.8421,-6.6795,0.0555,0.6888,4.7942,-2.8758,0.0560,0.7000,5.0000,0.0000,0.0565,0.7112,5.2058,2.8758,0.3757},
				{0.0200,19.8570,-6.6736,0.0712,0.7834,4.7279,-3.3164,0.0720,0.8000,5.0000,0.0000,0.0728,0.8166,5.2721,3.3164,0.3760},
				{0.0200,19.8737,-6.6670,0.0887,0.8764,4.6530,-3.7414,0.0900,0.9000,5.0000,0.0000,0.0913,0.9236,5.3470,3.7414,0.3764},
				{0.0200,19.8923,-6.6596,0.1080,0.9678,4.5700,-4.1500,0.1100,1.0000,5.0000,0.0000,0.1120,1.0322,5.4300,4.1500,0.3769},
				{0.0200,19.9128,-6.6515,0.1292,1.0574,4.4792,-4.5420,0.1320,1.1000,5.0000,0.0000,0.1348,1.1426,5.5208,4.5420,0.3776},
				{0.0200,19.9351,-6.6427,0.1521,1.1450,4.3809,-4.9175,0.1560,1.2000,5.0000,0.0000,0.1599,1.2550,5.6191,4.9175,0.3786},
				{0.0200,19.9592,-6.6330,0.1767,1.2305,4.2753,-5.2771,0.1820,1.3000,5.0000,0.0000,0.1873,1.3695,5.7247,5.2771,0.3797},
				{0.0200,19.9852,-6.6226,0.2030,1.3138,4.1629,-5.6219,0.2100,1.4000,5.0000,0.0000,0.2170,1.4862,5.8371,5.6218,0.3812},
				{0.0200,20.0131,-6.6115,0.2309,1.3947,4.0438,-5.9530,0.2400,1.5000,5.0000,0.0000,0.2491,1.6053,5.9562,5.9529,0.3829},
				{0.0200,20.0427,-6.5995,0.2603,1.4730,3.9184,-6.2719,0.2720,1.6000,5.0000,0.0000,0.2837,1.7270,6.0816,6.2717,0.3851},
				{0.0200,20.0742,-6.5867,0.2913,1.5488,3.7868,-6.5802,0.3060,1.7000,5.0000,0.0000,0.3207,1.8512,6.2132,6.5800,0.3876},
				{0.0200,20.1075,-6.5730,0.3237,1.6218,3.6492,-6.8793,0.3420,1.8000,5.0000,0.0000,0.3603,1.9782,6.3508,6.8789,0.3906},
				{0.0200,20.1427,-6.5585,0.3576,1.6919,3.5058,-7.1701,0.3800,1.9000,5.0000,0.0000,0.4024,2.1081,6.4942,7.1697,0.3941},
				{0.0200,20.1796,-6.5430,0.3928,1.7590,3.3567,-7.4534,0.4200,2.0000,5.0000,0.0000,0.4472,2.2410,6.6432,7.4529,0.3982},
				{0.0200,20.2182,-6.5267,0.4292,1.8231,3.2021,-7.7288,0.4620,2.1000,5.0000,0.0000,0.4948,2.3769,6.7978,7.7282,0.4028},
				{0.0200,20.2587,-6.5093,0.4669,1.8839,3.0422,-7.9949,0.5060,2.2000,5.0000,0.0000,0.5451,2.5161,6.9577,7.9941,0.4081},
				{0.0200,20.3008,-6.4909,0.5057,1.9414,2.8773,-8.2486,0.5520,2.3000,5.0000,0.0000,0.5983,2.6585,7.1226,8.2476,0.4142},
				{0.0200,20.3447,-6.4715,0.5456,1.9956,2.7076,-8.4849,0.6000,2.4000,5.0000,0.0000,0.6544,2.8044,7.2923,8.4837,0.4210},
				{0.0200,20.3903,-6.4509,0.5866,2.0463,2.5336,-8.6963,0.6500,2.5000,5.0000,0.0000,0.7134,2.9537,7.4662,8.6948,0.4286},
				{0.0200,20.4375,-6.4291,0.6284,2.0934,2.3562,-8.8721,0.7020,2.6000,5.0000,0.0000,0.7756,3.1066,7.6436,8.8703,0.4371},
				{0.0200,20.4863,-6.4060,0.6712,2.1369,2.1763,-8.9977,0.7560,2.7000,5.0000,0.0000,0.8408,3.2631,7.8235,8.9955,0.4466},
				{0.0200,20.5367,-6.3815,0.7147,2.1768,1.9952,-9.0541,0.8120,2.8000,5.0000,0.0000,0.9093,3.4232,8.0046,9.0516,0.4570},
				{0.0200,20.5886,-6.3556,0.7590,2.2131,1.8148,-9.0172,0.8700,2.9000,5.0000,0.0000,0.9810,3.5868,8.1848,9.0143,0.4686},
				{0.0200,20.6419,-6.3282,0.8039,2.2459,1.6377,-8.8569,0.9300,3.0000,5.0000,0.0000,1.0561,3.7541,8.3619,8.8535,0.4812},
				{0.0200,20.6967,-6.2991,0.8494,2.2752,1.4669,-8.5369,0.9920,3.1000,5.0000,0.0000,1.1346,3.9247,8.5326,8.5331,0.4951},
				{0.0200,20.7528,-6.2683,0.8954,2.3013,1.3067,-8.0147,1.0560,3.2000,5.0000,0.0000,1.2166,4.0986,8.6928,8.0104,0.5102},
				{0.0200,20.8101,-6.2356,0.9419,2.3246,1.1618,-7.2417,1.1220,3.3000,5.0000,0.0000,1.3021,4.2753,8.8375,7.2370,0.5266},
				{0.0200,20.8686,-6.2009,0.9888,2.3454,1.0385,-6.1647,1.1900,3.4000,5.0000,0.0000,1.3912,4.4546,8.9607,6.1596,0.5443},
				{0.0200,20.9281,-6.1641,1.0361,2.3642,0.9440,-4.7286,1.2600,3.5000,5.0000,0.0000,1.4839,4.6357,9.0552,4.7232,0.5634},
				{0.0200,20.9886,-6.1250,1.0837,2.3820,0.8864,-2.8801,1.3320,3.6000,5.0000,0.0000,1.5802,4.8179,9.1127,2.8746,0.5839},
				{0.0200,21.0499,-6.0836,1.1317,2.3995,0.8749,-0.5736,1.4060,3.7000,5.0000,0.0000,1.6803,5.0004,9.1240,0.5683,0.6057},
				{0.0200,21.1119,-6.0396,1.1801,2.4178,0.9193,2.2213,1.4820,3.8000,5.0000,0.0000,1.7839,5.1820,9.0795,-2.2262,0.6290},
				{0.0200,21.1744,-5.9929,1.2289,2.4384,1.0295,5.5106,1.5600,3.9000,5.0000,0.0000,1.8911,5.3614,8.9692,-5.5148,0.6535},
				{0.0200,21.2373,-5.9435,1.2781,2.4627,1.2148,9.2664,1.6400,4.0000,5.0000,0.0000,2.0019,5.5370,8.7838,-9.2694,0.6794},
				{0.0200,21.3003,-5.8911,1.3280,2.4924,1.4832,13.4174,1.7220,4.1000,5.0000,0.0000,2.1160,5.7074,8.5155,-13.4186,0.7064},
				{0.0200,21.3635,-5.8357,1.3785,2.5292,1.8401,17.8429,1.8060,4.2000,5.0000,0.0000,2.2334,5.8705,8.1586,-17.8421,0.7345},
				{0.0200,21.4265,-5.7771,1.4300,2.5749,2.2875,22.3722,1.8920,4.3000,5.0000,0.0000,2.3539,6.0248,7.7112,-22.3688,0.7635},
				{0.0200,21.4891,-5.7153,1.4827,2.6314,2.8233,26.7910,1.9800,4.4000,5.0000,0.0000,2.4773,6.1683,7.1755,-26.7849,0.7932},
				{0.0200,21.5513,-5.6503,1.5367,2.7002,3.4405,30.8575,2.0700,4.5000,5.0000,0.0000,2.6033,6.2994,6.5586,-30.8485,0.8234},
				{0.0200,21.6101,-5.5848,1.5899,2.6611,-1.9545,-269.7495,2.1580,4.4000,-5.0000,0.0000,2.7260,6.1386,-8.0440,-730.1278,0.8527},
				{0.0200,21.6658,-5.5193,1.6425,2.6316,-1.4787,23.7905,2.2440,4.3000,-5.0000,0.0000,2.8454,5.9682,-8.5197,-23.7869,0.8807},
				{0.0200,21.7184,-5.4538,1.6947,2.6093,-1.1118,18.3479,2.3280,4.2000,-5.0000,0.0000,2.9612,5.7904,-8.8867,-18.3474,0.9074},
				{0.0200,21.7681,-5.3886,1.7466,2.5923,-0.8486,13.1558,2.4100,4.1000,-5.0000,0.0000,3.0734,5.6074,-9.1498,-13.1578,0.9328},
				{0.0200,21.8149,-5.3237,1.7981,2.5787,-0.6806,8.4037,2.4900,4.0000,-5.0000,0.0000,3.1818,5.4211,-9.3180,-8.4077,0.9566},
				{0.0200,21.8592,-5.2595,1.8495,2.5668,-0.5963,4.2127,2.5680,3.9000,-5.0000,0.0000,3.2864,5.2330,-9.4023,-4.2180,0.9791},
				{0.0200,21.9009,-5.1960,1.9006,2.5551,-0.5835,0.6409,2.6440,3.8000,-5.0000,0.0000,3.3873,5.0447,-9.4153,-0.6471,1.0000},
				{0.0200,21.9403,-5.1333,1.9514,2.5425,-0.6296,-2.3049,2.7180,3.7000,-5.0000,0.0000,3.4845,4.8573,-9.3693,2.2983,1.0194},
				{0.0200,21.9774,-5.0716,2.0020,2.5281,-0.7227,-4.6560,2.7900,3.6000,-5.0000,0.0000,3.5779,4.6718,-9.2763,4.6494,1.0374},
				{0.0200,22.0125,-5.0111,2.0522,2.5111,-0.8521,-6.4681,2.8600,3.5000,-5.0000,0.0000,3.6677,4.4889,-9.1471,6.4618,1.0541},
				{0.0200,22.0456,-4.9517,2.1020,2.4909,-1.0083,-7.8098,2.9280,3.4000,-5.0000,0.0000,3.7539,4.3090,-8.9910,7.8039,1.0693},
				{0.0200,22.0770,-4.8936,2.1514,2.4672,-1.1834,-8.7541,2.9940,3.3000,-5.0000,0.0000,3.8365,4.1327,-8.8160,8.7487,1.0833},
				{0.0200,22.1066,-4.8369,2.2002,2.4398,-1.3708,-9.3717,3.0580,3.2000,-5.0000,0.0000,3.9157,3.9602,-8.6287,9.3669,1.0961},
				{0.0200,22.1346,-4.7815,2.2483,2.4085,-1.5653,-9.7278,3.1200,3.1000,-5.0000,0.0000,3.9916,3.7915,-8.4342,9.7235,1.1077},
				{0.0200,22.1611,-4.7277,2.2958,2.3732,-1.7629,-9.8795,3.1800,3.0000,-5.0000,0.0000,4.0641,3.6267,-8.2367,9.8758,1.1183},
				{0.0200,22.1862,-4.6754,2.3425,2.3340,-1.9604,-9.8757,3.2380,2.9000,-5.0000,0.0000,4.1334,3.4660,-8.0393,9.8725,1.1278},
				{0.0200,22.2100,-4.6247,2.3883,2.2909,-2.1556,-9.7564,3.2940,2.8000,-5.0000,0.0000,4.1996,3.3091,-7.8442,9.7537,1.1363},
				{0.0200,22.2325,-4.5757,2.4332,2.2440,-2.3467,-9.5542,3.3480,2.7000,-5.0000,0.0000,4.2627,3.1560,-7.6531,9.5519,1.1440},
				{0.0200,22.2539,-4.5283,2.4770,2.1933,-2.5325,-9.2945,3.4000,2.6000,-5.0000,0.0000,4.3229,3.0067,-7.4673,9.2926,1.1508},
				{0.0200,22.2741,-4.4825,2.5198,2.1391,-2.7125,-8.9970,3.4500,2.5000,-5.0000,0.0000,4.3801,2.8609,-7.2874,8.9954,1.1569},
				{0.0200,22.2933,-4.4385,2.5615,2.0814,-2.8860,-8.6764,3.4980,2.4000,-5.0000,0.0000,4.4344,2.7186,-7.1139,8.6751,1.1623},
				{0.0200,22.3115,-4.3963,2.6019,2.0203,-3.0529,-8.3433,3.5440,2.3000,-5.0000,0.0000,4.4860,2.5797,-6.9470,8.3422,1.1670},
				{0.0200,22.3287,-4.3558,2.6410,1.9560,-3.2130,-8.0051,3.5880,2.2000,-5.0000,0.0000,4.5349,2.4440,-6.7870,8.0042,1.1711},
				{0.0200,22.3450,-4.3171,2.6788,1.8887,-3.3663,-7.6667,3.6300,2.1000,-5.0000,0.0000,4.5811,2.3113,-6.6336,7.6661,1.1746},
				{0.0200,22.3604,-4.2801,2.7151,1.8185,-3.5129,-7.3311,3.6700,2.0000,-5.0000,0.0000,4.6248,2.1815,-6.4870,7.3306,1.1777},
				{0.0200,22.3749,-4.2450,2.7500,1.7454,-3.6529,-6.9996,3.7080,1.9000,-5.0000,0.0000,4.6659,2.0546,-6.3470,6.9992,1.1803},
				{0.0200,22.3885,-4.2117,2.7834,1.6697,-3.7864,-6.6725,3.7440,1.8000,-5.0000,0.0000,4.7045,1.9303,-6.2136,6.6722,1.1824},
				{0.0200,22.4014,-4.1802,2.8153,1.5914,-3.9134,-6.3494,3.7780,1.7000,-5.0000,0.0000,4.7406,1.8086,-6.0866,6.3491,1.1843},
				{0.0200,22.4134,-4.1506,2.8455,1.5107,-4.0340,-6.0291,3.8100,1.6000,-5.0000,0.0000,4.7744,1.6893,-5.9660,6.0289,1.1858},
				{0.0200,22.4247,-4.1228,2.8740,1.4278,-4.1482,-5.7104,3.8400,1.5000,-5.0000,0.0000,4.8059,1.5722,-5.8518,5.7103,1.1870},
				{0.0200,22.4351,-4.0968,2.9009,1.3426,-4.2560,-5.3917,3.8680,1.4000,-5.0000,0.0000,4.8350,1.4574,-5.7440,5.3916,1.1880},
				{0.0200,22.4449,-4.0727,2.9260,1.2555,-4.3574,-5.0715,3.8940,1.3000,-5.0000,0.0000,4.8619,1.3445,-5.6426,5.0714,1.1887},
				{0.0200,22.4538,-4.0504,2.9493,1.1664,-4.4524,-4.7483,3.9180,1.2000,-5.0000,0.0000,4.8866,1.2336,-5.5476,4.7482,1.1893},
				{0.0200,22.4620,-4.0300,2.9708,1.0756,-4.5408,-4.4207,3.9400,1.1000,-5.0000,0.0000,4.9091,1.1244,-5.4592,4.4207,1.1897},
				{0.0200,22.4694,-4.0114,2.9905,0.9832,-4.6226,-4.0877,3.9600,1.0000,-5.0000,0.0000,4.9294,1.0168,-5.3774,4.0877,1.1900},
				{0.0200,22.4761,-3.9947,3.0083,0.8892,-4.6975,-3.7482,3.9780,0.9000,-5.0000,0.0000,4.9476,0.9108,-5.3025,3.7482,1.1901},
				{0.0200,22.4821,-3.9799,3.0242,0.7939,-4.7656,-3.4018,3.9940,0.8000,-5.0000,0.0000,4.9637,0.8061,-5.2344,3.4018,1.1902},
				{0.0200,22.4873,-3.9669,3.0381,0.6974,-4.8265,-3.0480,4.0080,0.7000,-5.0000,0.0000,4.9778,0.7026,-5.1735,3.0480,1.1903},
				{0.0200,22.4900,-3.9600,3.0455,0.3697,-16.3846,-577.9015,4.0154,0.6000,-5.0000,0.0000,4.9852,0.3704,-16.6103,-571.8404,1.1903},
				{0.0200,22.4900,-3.9600,3.0455,0.0000,-18.4848,-105.0125,4.0154,0.5000,-5.0000,0.0000,4.9852,0.0000,-18.5204,-95.5038,1.1903},
				{0.0200,22.4900,-3.9600,3.0455,0.0000,0.0000,924.2402,4.0154,0.4000,-5.0000,0.0000,4.9852,0.0000,0.0000,926.0179,1.1903},
				{0.0200,22.4900,-3.9600,3.0455,0.0000,0.0000,0.0000,4.0154,0.3000,-5.0000,0.0000,4.9852,0.0000,0.0000,0.0000,1.1903},
				{0.0200,22.4900,-3.9600,3.0455,0.0000,0.0000,0.0000,4.0154,0.2000,-5.0000,0.0000,4.9852,0.0000,0.0000,0.0000,1.1903},
				{0.0200,22.4900,-3.9600,3.0455,0.0000,0.0000,0.0000,4.0154,0.1000,-5.0000,0.0000,4.9852,0.0000,0.0000,0.0000,1.1903},
				{0.0200,22.4900,-3.9600,3.0455,0.0000,0.0000,0.0000,4.0154,-0.0000,-5.0000,0.0000,4.9852,0.0000,0.0000,0.0000,1.1903},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}