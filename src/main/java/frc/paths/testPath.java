package frc.paths;

import com.team319.trajectory.Path;

public class testPath extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,6.4220,6.1800,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,-0.0000},
				{0.0200,6.4260,6.1800,0.0060,0.2000,5.0002,0.0106,0.0060,0.2000,5.0000,0.0000,0.0060,0.2000,4.9998,-0.0106,-0.0000},
				{0.0200,6.4320,6.1800,0.0120,0.3000,5.0005,0.0146,0.0120,0.3000,5.0000,0.0000,0.0120,0.3000,4.9995,-0.0146,-0.0000},
				{0.0200,6.4400,6.1800,0.0200,0.4000,5.0010,0.0239,0.0200,0.4000,5.0000,0.0000,0.0200,0.4000,4.9990,-0.0239,-0.0000},
				{0.0200,6.4500,6.1800,0.0300,0.5001,5.0016,0.0317,0.0300,0.5000,5.0000,0.0000,0.0300,0.4999,4.9984,-0.0317,-0.0000},
				{0.0200,6.4620,6.1800,0.0420,0.6001,5.0024,0.0395,0.0420,0.6000,5.0000,0.0000,0.0420,0.5999,4.9976,-0.0395,-0.0000},
				{0.0200,6.4760,6.1800,0.0560,0.7002,5.0034,0.0472,0.0560,0.7000,5.0000,0.0000,0.0560,0.6998,4.9966,-0.0472,-0.0000},
				{0.0200,6.4920,6.1800,0.0720,0.8003,5.0044,0.0547,0.0720,0.8000,5.0000,0.0000,0.0720,0.7997,4.9956,-0.0547,-0.0000},
				{0.0200,6.5100,6.1800,0.0900,0.9004,5.0057,0.0622,0.0900,0.9000,5.0000,0.0000,0.0900,0.8996,4.9943,-0.0622,-0.0000},
				{0.0200,6.5300,6.1800,0.1100,1.0005,5.0071,0.0694,0.1100,1.0000,5.0000,0.0000,0.1100,0.9995,4.9929,-0.0694,-0.0000},
				{0.0200,6.5520,6.1800,0.1320,1.1007,5.0086,0.0765,0.1320,1.1000,5.0000,0.0000,0.1320,1.0993,4.9914,-0.0765,-0.0000},
				{0.0200,6.5760,6.1800,0.1561,1.2009,5.0103,0.0833,0.1560,1.2000,5.0000,0.0000,0.1559,1.1991,4.9897,-0.0833,-0.0000},
				{0.0200,6.6020,6.1800,0.1821,1.3011,5.0121,0.0900,0.1820,1.3000,5.0000,0.0000,0.1819,1.2989,4.9879,-0.0900,-0.0001},
				{0.0200,6.6300,6.1800,0.2101,1.4014,5.0140,0.0964,0.2100,1.4000,5.0000,0.0000,0.2099,1.3986,4.9860,-0.0964,-0.0001},
				{0.0200,6.6600,6.1800,0.2402,1.5017,5.0161,0.1026,0.2400,1.5000,5.0000,0.0000,0.2398,1.4983,4.9839,-0.1026,-0.0001},
				{0.0200,6.6920,6.1800,0.2722,1.6021,5.0182,0.1084,0.2720,1.6000,5.0000,0.0000,0.2718,1.5979,4.9818,-0.1084,-0.0001},
				{0.0200,6.7260,6.1800,0.3062,1.7025,5.0205,0.1140,0.3060,1.7000,5.0000,0.0000,0.3058,1.6975,4.9795,-0.1140,-0.0001},
				{0.0200,6.7620,6.1800,0.3423,1.8030,5.0229,0.1193,0.3420,1.8000,5.0000,0.0000,0.3417,1.7970,4.9771,-0.1193,-0.0002},
				{0.0200,6.8000,6.1800,0.3804,1.9035,5.0254,0.1242,0.3800,1.9000,5.0000,0.0000,0.3796,1.8965,4.9746,-0.1242,-0.0002},
				{0.0200,6.8400,6.1800,0.4205,2.0040,5.0279,0.1288,0.4200,2.0000,5.0000,0.0000,0.4195,1.9960,4.9721,-0.1288,-0.0003},
				{0.0200,6.8820,6.1799,0.4625,2.1047,5.0306,0.1331,0.4620,2.1000,5.0000,0.0000,0.4615,2.0953,4.9694,-0.1331,-0.0003},
				{0.0200,6.9260,6.1799,0.5067,2.2053,5.0333,0.1369,0.5060,2.2000,5.0000,0.0000,0.5053,2.1947,4.9667,-0.1369,-0.0004},
				{0.0200,6.9720,6.1799,0.5528,2.3060,5.0362,0.1404,0.5520,2.3000,5.0000,0.0000,0.5512,2.2940,4.9638,-0.1404,-0.0005},
				{0.0200,7.0200,6.1799,0.6009,2.4068,5.0390,0.1434,0.6000,2.4000,5.0000,0.0000,0.5991,2.3932,4.9610,-0.1434,-0.0005},
				{0.0200,7.0700,6.1799,0.6511,2.5077,5.0419,0.1461,0.6500,2.5000,5.0000,0.0000,0.6489,2.4923,4.9581,-0.1461,-0.0006},
				{0.0200,7.1220,6.1798,0.7032,2.6086,5.0449,0.1483,0.7020,2.6000,5.0000,0.0000,0.7008,2.5914,4.9551,-0.1483,-0.0007},
				{0.0200,7.1760,6.1798,0.7574,2.7095,5.0479,0.1500,0.7560,2.7000,5.0000,0.0000,0.7546,2.6905,4.9521,-0.1500,-0.0009},
				{0.0200,7.2320,6.1797,0.8136,2.8105,5.0509,0.1513,0.8120,2.8000,5.0000,0.0000,0.8104,2.7895,4.9491,-0.1513,-0.0010},
				{0.0200,7.2900,6.1797,0.8719,2.9116,5.0540,0.1522,0.8700,2.9000,5.0000,0.0000,0.8681,2.8884,4.9460,-0.1522,-0.0011},
				{0.0200,7.3500,6.1796,0.9321,3.0128,5.0570,0.1525,0.9300,3.0000,5.0000,0.0000,0.9279,2.9872,4.9430,-0.1525,-0.0013},
				{0.0200,7.4120,6.1795,0.9944,3.1140,5.0601,0.1524,0.9920,3.1000,5.0000,0.0000,0.9896,3.0860,4.9399,-0.1524,-0.0014},
				{0.0200,7.4760,6.1794,1.0587,3.2152,5.0631,0.1517,1.0560,3.2000,5.0000,0.0000,1.0533,3.1848,4.9369,-0.1517,-0.0016},
				{0.0200,7.5420,6.1793,1.1250,3.3165,5.0661,0.1505,1.1220,3.3000,5.0000,0.0000,1.1190,3.2835,4.9339,-0.1505,-0.0018},
				{0.0200,7.6100,6.1792,1.1934,3.4179,5.0691,0.1488,1.1900,3.4000,5.0000,0.0000,1.1866,3.3821,4.9309,-0.1488,-0.0020},
				{0.0200,7.6800,6.1790,1.2638,3.5194,5.0720,0.1466,1.2600,3.5000,5.0000,0.0000,1.2562,3.4806,4.9280,-0.1466,-0.0023},
				{0.0200,7.7520,6.1788,1.3362,3.6209,5.0749,0.1439,1.3320,3.6000,5.0000,0.0000,1.3278,3.5791,4.9251,-0.1439,-0.0025},
				{0.0200,7.8260,6.1786,1.4107,3.7224,5.0777,0.1406,1.4060,3.7000,5.0000,0.0000,1.4013,3.6776,4.9223,-0.1406,-0.0028},
				{0.0200,7.9020,6.1784,1.4871,3.8240,5.0805,0.1367,1.4820,3.8000,5.0000,0.0000,1.4769,3.7760,4.9195,-0.1367,-0.0031},
				{0.0200,7.9800,6.1782,1.5656,3.9257,5.0831,0.1323,1.5600,3.9000,5.0000,0.0000,1.5544,3.8743,4.9169,-0.1323,-0.0034},
				{0.0200,8.0600,6.1779,1.6462,4.0274,5.0857,0.1274,1.6400,4.0000,5.0000,0.0000,1.6338,3.9726,4.9143,-0.1274,-0.0037},
				{0.0200,8.1420,6.1776,1.7288,4.1292,5.0881,0.1219,1.7220,4.1000,5.0000,0.0000,1.7152,4.0708,4.9119,-0.1219,-0.0041},
				{0.0200,8.2260,6.1772,1.8134,4.2310,5.0904,0.1158,1.8060,4.2000,5.0000,0.0000,1.7986,4.1690,4.9096,-0.1158,-0.0045},
				{0.0200,8.3120,6.1768,1.9001,4.3328,5.0926,0.1091,1.8920,4.3000,5.0000,0.0000,1.8839,4.2672,4.9074,-0.1092,-0.0049},
				{0.0200,8.4000,6.1764,1.9887,4.4347,5.0946,0.1020,1.9800,4.4000,5.0000,0.0000,1.9713,4.3653,4.9054,-0.1020,-0.0053},
				{0.0200,8.4900,6.1759,2.0795,4.5367,5.0965,0.0942,2.0700,4.5000,5.0000,0.0000,2.0605,4.4633,4.9035,-0.0942,-0.0057},
				{0.0200,8.5820,6.1753,2.1723,4.6386,5.0982,0.0859,2.1620,4.6000,5.0000,0.0000,2.1517,4.5614,4.9018,-0.0859,-0.0062},
				{0.0200,8.6760,6.1747,2.2671,4.7406,5.0998,0.0770,2.2560,4.7000,5.0000,0.0000,2.2449,4.6594,4.9002,-0.0770,-0.0067},
				{0.0200,8.7720,6.1740,2.3639,4.8426,5.1011,0.0676,2.3520,4.8000,5.0000,0.0000,2.3401,4.7574,4.8989,-0.0676,-0.0072},
				{0.0200,8.8700,6.1733,2.4628,4.9447,5.1023,0.0577,2.4500,4.9000,5.0000,0.0000,2.4372,4.8553,4.8977,-0.0577,-0.0077},
				{0.0200,8.9700,6.1725,2.5637,5.0467,5.1032,0.0472,2.5500,5.0000,5.0000,0.0000,2.5363,4.9533,4.8968,-0.0472,-0.0083},
				{0.0200,9.0720,6.1716,2.6667,5.1488,5.1039,0.0362,2.6520,5.1000,5.0000,0.0000,2.6373,5.0512,4.8961,-0.0362,-0.0089},
				{0.0200,9.1760,6.1707,2.7717,5.2509,5.1044,0.0246,2.7560,5.2000,5.0000,0.0000,2.7403,5.1491,4.8956,-0.0246,-0.0095},
				{0.0200,9.2820,6.1697,2.8788,5.3530,5.1047,0.0126,2.8620,5.3000,5.0000,0.0000,2.8452,5.2470,4.8953,-0.0126,-0.0101},
				{0.0200,9.3900,6.1685,2.9879,5.4551,5.1047,0.0000,2.9700,5.4000,5.0000,0.0000,2.9521,5.3449,4.8953,-0.0000,-0.0108},
				{0.0200,9.5000,6.1673,3.0990,5.5572,5.1044,-0.0130,3.0800,5.5000,5.0000,0.0000,3.0610,5.4428,4.8956,0.0130,-0.0115},
				{0.0200,9.6119,6.1660,3.2122,5.6593,5.1039,-0.0265,3.1920,5.6000,5.0000,0.0000,3.1718,5.5407,4.8961,0.0265,-0.0122},
				{0.0200,9.7259,6.1645,3.3275,5.7613,5.1031,-0.0404,3.3060,5.7000,5.0000,0.0000,3.2845,5.6387,4.8969,0.0404,-0.0129},
				{0.0200,9.8419,6.1630,3.4447,5.8634,5.1020,-0.0548,3.4220,5.8000,5.0000,0.0000,3.3993,5.7366,4.8980,0.0548,-0.0137},
				{0.0200,9.9599,6.1613,3.5640,5.9654,5.1006,-0.0696,3.5400,5.9000,5.0000,0.0000,3.5160,5.8346,4.8994,0.0696,-0.0145},
				{0.0200,10.0799,6.1596,3.6854,6.0674,5.0989,-0.0848,3.6600,6.0000,5.0000,0.0000,3.6346,5.9326,4.9011,0.0848,-0.0153},
				{0.0200,10.2019,6.1576,3.8088,6.1693,5.0969,-0.1004,3.7820,6.1000,5.0000,0.0000,3.7552,6.0307,4.9031,0.1004,-0.0161},
				{0.0200,10.3259,6.1556,3.9342,6.2712,5.0946,-0.1164,3.9060,6.2000,5.0000,0.0000,3.8778,6.1288,4.9054,0.1164,-0.0170},
				{0.0200,10.4519,6.1534,4.0617,6.3730,5.0919,-0.1326,4.0320,6.3000,5.0000,0.0000,4.0023,6.2270,4.9081,0.1326,-0.0179},
				{0.0200,10.5798,6.1510,4.1911,6.4748,5.0889,-0.1492,4.1600,6.4000,5.0000,0.0000,4.1289,6.3252,4.9111,0.1492,-0.0188},
				{0.0200,10.7098,6.1485,4.3227,6.5765,5.0856,-0.1660,4.2900,6.5000,5.0000,0.0000,4.2573,6.4235,4.9144,0.1660,-0.0197},
				{0.0200,10.8418,6.1459,4.4562,6.6782,5.0820,-0.1831,4.4220,6.6000,5.0000,0.0000,4.3878,6.5218,4.9180,0.1831,-0.0206},
				{0.0200,10.9757,6.1431,4.5918,6.7797,5.0779,-0.2004,4.5560,6.7000,5.0000,0.0000,4.5202,6.6203,4.9221,0.2004,-0.0216},
				{0.0200,11.1117,6.1401,4.7295,6.8812,5.0736,-0.2178,4.6920,6.8000,5.0000,0.0000,4.6545,6.7188,4.9264,0.2178,-0.0226},
				{0.0200,11.2497,6.1369,4.8691,6.9826,5.0689,-0.2354,4.8300,6.9000,5.0000,0.0000,4.7909,6.8174,4.9311,0.2354,-0.0236},
				{0.0200,11.3896,6.1335,5.0108,7.0838,5.0638,-0.2531,4.9700,7.0000,5.0000,0.0000,4.9292,6.9162,4.9362,0.2531,-0.0246},
				{0.0200,11.5316,6.1299,5.1545,7.1850,5.0584,-0.2709,5.1120,7.1000,5.0000,0.0000,5.0695,7.0150,4.9416,0.2709,-0.0256},
				{0.0200,11.6755,6.1262,5.3002,7.2861,5.0526,-0.2887,5.2560,7.2000,5.0000,0.0000,5.2118,7.1139,4.9474,0.2887,-0.0266},
				{0.0200,11.8215,6.1222,5.4479,7.3870,5.0465,-0.3064,5.4020,7.3000,5.0000,0.0000,5.3561,7.2130,4.9535,0.3064,-0.0277},
				{0.0200,11.9694,6.1180,5.5977,7.4878,5.0400,-0.3242,5.5500,7.4000,5.0000,0.0000,5.5023,7.3122,4.9600,0.3242,-0.0287},
				{0.0200,12.1194,6.1137,5.7495,7.5885,5.0332,-0.3418,5.7000,7.5000,5.0000,0.0000,5.6505,7.4115,4.9668,0.3418,-0.0298},
				{0.0200,12.2713,6.1090,5.9033,7.6890,5.0260,-0.3592,5.8520,7.6000,5.0000,0.0000,5.8007,7.5110,4.9740,0.3592,-0.0309},
				{0.0200,12.4252,6.1042,6.0590,7.7893,5.0185,-0.3764,6.0060,7.7000,5.0000,0.0000,5.9530,7.6107,4.9815,0.3764,-0.0320},
				{0.0200,12.5811,6.0991,6.2168,7.8896,5.0106,-0.3934,6.1620,7.8000,5.0000,0.0000,6.1072,7.7104,4.9894,0.3934,-0.0330},
				{0.0200,12.7391,6.0938,6.3766,7.9896,5.0024,-0.4101,6.3200,7.9000,5.0000,0.0000,6.2634,7.8104,4.9976,0.4101,-0.0341},
				{0.0200,12.8990,6.0883,6.5384,8.0895,4.9939,-0.4264,6.4800,8.0000,5.0000,0.0000,6.4216,7.9105,5.0061,0.4264,-0.0352},
				{0.0200,13.0609,6.0825,6.7022,8.1892,4.9850,-0.4422,6.6420,8.1000,5.0000,0.0000,6.5818,8.0108,5.0150,0.4422,-0.0363},
				{0.0200,13.2247,6.0765,6.8680,8.2887,4.9759,-0.4576,6.8060,8.2000,5.0000,0.0000,6.7440,8.1113,5.0241,0.4576,-0.0373},
				{0.0200,13.3906,6.0702,7.0357,8.3880,4.9664,-0.4725,6.9720,8.3000,5.0000,0.0000,6.9083,8.2120,5.0336,0.4725,-0.0384},
				{0.0200,13.5585,6.0637,7.2055,8.4872,4.9567,-0.4867,7.1400,8.4000,5.0000,0.0000,7.0745,8.3128,5.0433,0.4868,-0.0394},
				{0.0200,13.7284,6.0569,7.3772,8.5861,4.9467,-0.5003,7.3100,8.5000,5.0000,0.0000,7.2428,8.4139,5.0533,0.5004,-0.0405},
				{0.0200,13.9002,6.0498,7.5509,8.6848,4.9364,-0.5132,7.4820,8.6000,5.0000,0.0000,7.4131,8.5152,5.0636,0.5132,-0.0415},
				{0.0200,14.0741,6.0425,7.7266,8.7833,4.9259,-0.5253,7.6560,8.7000,5.0000,0.0000,7.5854,8.6167,5.0741,0.5253,-0.0425},
				{0.0200,14.2499,6.0349,7.9042,8.8816,4.9152,-0.5365,7.8320,8.8000,5.0000,0.0000,7.7598,8.7184,5.0848,0.5365,-0.0435},
				{0.0200,14.4277,6.0271,8.0838,8.9797,4.9042,-0.5468,8.0100,8.9000,5.0000,0.0000,7.9362,8.8203,5.0958,0.5468,-0.0444},
				{0.0200,14.6075,6.0190,8.2653,9.0776,4.8931,-0.5560,8.1900,9.0000,5.0000,0.0000,8.1147,8.9224,5.1069,0.5560,-0.0454},
				{0.0200,14.7894,6.0107,8.4488,9.1752,4.8818,-0.5642,8.3720,9.1000,5.0000,0.0000,8.2952,9.0248,5.1182,0.5642,-0.0463},
				{0.0200,14.9732,6.0021,8.6343,9.2726,4.8704,-0.5713,8.5560,9.2000,5.0000,0.0000,8.4777,9.1274,5.1296,0.5713,-0.0472},
				{0.0200,15.1589,5.9932,8.8217,9.3698,4.8589,-0.5771,8.7420,9.3000,5.0000,0.0000,8.6623,9.2302,5.1411,0.5771,-0.0480},
				{0.0200,15.3467,5.9841,9.0110,9.4668,4.8472,-0.5816,8.9300,9.4000,5.0000,0.0000,8.8490,9.3332,5.1528,0.5816,-0.0488},
				{0.0200,15.5365,5.9748,9.2023,9.5635,4.8355,-0.5847,9.1200,9.5000,5.0000,0.0000,9.0377,9.4365,5.1645,0.5847,-0.0496},
				{0.0200,15.7283,5.9652,9.3955,9.6599,4.8238,-0.5864,9.3120,9.6000,5.0000,0.0000,9.2285,9.5401,5.1762,0.5864,-0.0503},
				{0.0200,15.9220,5.9554,9.5906,9.7562,4.8121,-0.5865,9.5060,9.7000,5.0000,0.0000,9.4214,9.6438,5.1879,0.5865,-0.0510},
				{0.0200,16.1177,5.9453,9.7877,9.8522,4.8004,-0.5849,9.7020,9.8000,5.0000,0.0000,9.6163,9.7478,5.1996,0.5849,-0.0516},
				{0.0200,16.3155,5.9351,9.9866,9.9480,4.7888,-0.5816,9.9000,9.9000,5.0000,0.0000,9.8134,9.8520,5.2112,0.5816,-0.0522},
				{0.0200,16.5152,5.9246,10.1875,10.0435,4.7772,-0.5765,10.1000,10.0000,5.0000,0.0000,10.0125,9.9565,5.2228,0.5765,-0.0527},
				{0.0200,16.7149,5.9140,10.3883,10.0385,-0.2521,-251.4671,10.3000,10.0000,5.0000,0.0000,10.2117,9.9615,0.2521,-248.5328,-0.0532},
				{0.0200,16.9146,5.9033,10.5889,10.0334,-0.2555,-0.1710,10.5000,10.0000,5.0000,0.0000,10.4111,9.9666,0.2555,0.1710,-0.0536},
				{0.0200,17.1144,5.8926,10.7895,10.0282,-0.2585,-0.1476,10.7000,10.0000,5.0000,0.0000,10.6105,9.9718,0.2585,0.1476,-0.0539},
				{0.0200,17.3141,5.8818,10.9900,10.0230,-0.2610,-0.1243,10.9000,10.0000,5.0000,0.0000,10.8100,9.9770,0.2610,0.1242,-0.0542},
				{0.0200,17.5138,5.8709,11.1903,10.0177,-0.2630,-0.1009,11.1000,10.0000,5.0000,0.0000,11.0097,9.9823,0.2630,0.1009,-0.0544},
				{0.0200,17.7135,5.8600,11.3906,10.0124,-0.2645,-0.0776,11.3000,10.0000,5.0000,0.0000,11.2094,9.9876,0.2645,0.0776,-0.0546},
				{0.0200,17.9132,5.8491,11.5907,10.0071,-0.2656,-0.0544,11.5000,10.0000,5.0000,0.0000,11.4093,9.9929,0.2656,0.0543,-0.0546},
				{0.0200,18.1129,5.8382,11.7907,10.0018,-0.2663,-0.0311,11.7000,10.0000,5.0000,0.0000,11.6093,9.9982,0.2663,0.0311,-0.0547},
				{0.0200,18.3126,5.8273,11.9907,9.9965,-0.2664,-0.0078,11.9000,10.0000,5.0000,0.0000,11.8093,10.0035,0.2664,0.0078,-0.0546},
				{0.0200,18.5123,5.8164,12.1905,9.9911,-0.2661,0.0155,12.1000,10.0000,5.0000,0.0000,12.0095,10.0089,0.2661,-0.0155,-0.0545},
				{0.0200,18.7120,5.8055,12.3902,9.9858,-0.2653,0.0387,12.3000,10.0000,5.0000,0.0000,12.2098,10.0142,0.2653,-0.0387,-0.0543},
				{0.0200,18.9117,5.7946,12.5898,9.9805,-0.2641,0.0620,12.5000,10.0000,5.0000,0.0000,12.4102,10.0195,0.2641,-0.0620,-0.0541},
				{0.0200,19.1114,5.7839,12.7893,9.9753,-0.2624,0.0853,12.7000,10.0000,5.0000,0.0000,12.6107,10.0247,0.2624,-0.0853,-0.0538},
				{0.0200,19.3111,5.7731,12.9887,9.9701,-0.2602,0.1086,12.9000,10.0000,5.0000,0.0000,12.8113,10.0299,0.2602,-0.1086,-0.0534},
				{0.0200,19.5108,5.7625,13.1880,9.9649,-0.2576,0.1319,13.1000,10.0000,5.0000,0.0000,13.0120,10.0351,0.2576,-0.1319,-0.0530},
				{0.0200,19.7105,5.7519,13.3872,9.9599,-0.2545,0.1553,13.3000,10.0000,5.0000,0.0000,13.2128,10.0401,0.2545,-0.1553,-0.0525},
				{0.0200,19.9103,5.7415,13.5863,9.9548,-0.2509,0.1787,13.5000,10.0000,5.0000,0.0000,13.4137,10.0452,0.2509,-0.1787,-0.0520},
				{0.0200,20.1080,5.7313,13.7833,9.8504,-5.2206,-248.4851,13.6980,9.9000,-5.0000,0.0000,13.6127,9.9496,-4.7794,-251.5149,-0.0514},
				{0.0200,20.3037,5.7213,13.9782,9.7462,-5.2090,0.5819,13.8940,9.8000,-5.0000,0.0000,13.8098,9.8538,-4.7910,-0.5819,-0.0508},
				{0.0200,20.4975,5.7115,14.1711,9.6423,-5.1972,0.5866,14.0880,9.7000,-5.0000,0.0000,14.0049,9.7577,-4.8028,-0.5866,-0.0501},
				{0.0200,20.6893,5.7019,14.3619,9.5386,-5.1854,0.5894,14.2800,9.6000,-5.0000,0.0000,14.1981,9.6614,-4.8146,-0.5894,-0.0493},
				{0.0200,20.8790,5.6926,14.5506,9.4351,-5.1736,0.5906,14.4700,9.5000,-5.0000,0.0000,14.3894,9.5649,-4.8264,-0.5906,-0.0485},
				{0.0200,21.0668,5.6836,14.7372,9.3319,-5.1618,0.5901,14.6580,9.4000,-5.0000,0.0000,14.5788,9.4681,-4.8382,-0.5901,-0.0477},
				{0.0200,21.2526,5.6748,14.9218,9.2289,-5.1501,0.5881,14.8440,9.3000,-5.0000,0.0000,14.7662,9.3711,-4.8499,-0.5881,-0.0469},
				{0.0200,21.4364,5.6663,15.1043,9.1261,-5.1384,0.5846,15.0280,9.2000,-5.0000,0.0000,14.9517,9.2739,-4.8616,-0.5846,-0.0460},
				{0.0200,21.6182,5.6580,15.2848,9.0236,-5.1268,0.5797,15.2100,9.1000,-5.0000,0.0000,15.1352,9.1764,-4.8732,-0.5797,-0.0450},
				{0.0200,21.7980,5.6500,15.4632,8.9213,-5.1153,0.5736,15.3900,9.0000,-5.0000,0.0000,15.3168,9.0787,-4.8847,-0.5735,-0.0441},
				{0.0200,21.9759,5.6422,15.6396,8.8192,-5.1040,0.5662,15.5680,8.9000,-5.0000,0.0000,15.4964,8.9808,-4.8960,-0.5662,-0.0431},
				{0.0200,22.1517,5.6347,15.8139,8.7173,-5.0928,0.5577,15.7440,8.8000,-5.0000,0.0000,15.6741,8.8827,-4.9072,-0.5576,-0.0421},
				{0.0200,22.3256,5.6275,15.9862,8.6157,-5.0819,0.5481,15.9180,8.7000,-5.0000,0.0000,15.8498,8.7843,-4.9181,-0.5481,-0.0411},
				{0.0200,22.4974,5.6205,16.1565,8.5143,-5.0711,0.5375,16.0900,8.6000,-5.0000,0.0000,16.0235,8.6857,-4.9289,-0.5375,-0.0401},
				{0.0200,22.6673,5.6138,16.3248,8.4131,-5.0606,0.5260,16.2600,8.5000,-5.0000,0.0000,16.1952,8.5869,-4.9394,-0.5260,-0.0390},
				{0.0200,22.8352,5.6073,16.4910,8.3121,-5.0503,0.5136,16.4280,8.4000,-5.0000,0.0000,16.3650,8.4879,-4.9497,-0.5136,-0.0380},
				{0.0200,23.0011,5.6011,16.6553,8.2113,-5.0403,0.5005,16.5940,8.3000,-5.0000,0.0000,16.5327,8.3887,-4.9597,-0.5005,-0.0369},
				{0.0200,23.1649,5.5951,16.8175,8.1106,-5.0306,0.4866,16.7580,8.2000,-5.0000,0.0000,16.6985,8.2894,-4.9694,-0.4866,-0.0358},
				{0.0200,23.3268,5.5894,16.9777,8.0102,-5.0211,0.4721,16.9200,8.1000,-5.0000,0.0000,16.8623,8.1898,-4.9789,-0.4721,-0.0347},
				{0.0200,23.4867,5.5839,17.1359,7.9100,-5.0120,0.4570,17.0800,8.0000,-5.0000,0.0000,17.0241,8.0900,-4.9880,-0.4570,-0.0337},
				{0.0200,23.6447,5.5787,17.2921,7.8099,-5.0032,0.4413,17.2380,7.9000,-5.0000,0.0000,17.1839,7.9901,-4.9968,-0.4413,-0.0326},
				{0.0200,23.8006,5.5737,17.4463,7.7100,-4.9947,0.4252,17.3940,7.8000,-5.0000,0.0000,17.3417,7.8900,-5.0053,-0.4252,-0.0315},
				{0.0200,23.9545,5.5689,17.5985,7.6103,-4.9865,0.4087,17.5480,7.7000,-5.0000,0.0000,17.4975,7.7897,-5.0135,-0.4087,-0.0304},
				{0.0200,24.1064,5.5644,17.7487,7.5107,-4.9787,0.3918,17.7000,7.6000,-5.0000,0.0000,17.6513,7.6893,-5.0213,-0.3918,-0.0293},
				{0.0200,24.2564,5.5601,17.8969,7.4113,-4.9712,0.3746,17.8500,7.5000,-5.0000,0.0000,17.8031,7.5887,-5.0288,-0.3746,-0.0283},
				{0.0200,24.4043,5.5560,18.0432,7.3120,-4.9640,0.3572,17.9980,7.4000,-5.0000,0.0000,17.9528,7.4880,-5.0360,-0.3572,-0.0272},
				{0.0200,24.5503,5.5521,18.1874,7.2129,-4.9572,0.3395,18.1440,7.3000,-5.0000,0.0000,18.1006,7.3871,-5.0428,-0.3395,-0.0262},
				{0.0200,24.6942,5.5484,18.3297,7.1139,-4.9508,0.3218,18.2880,7.2000,-5.0000,0.0000,18.2463,7.2861,-5.0492,-0.3218,-0.0251},
				{0.0200,24.8362,5.5449,18.4700,7.0150,-4.9447,0.3039,18.4300,7.1000,-5.0000,0.0000,18.3900,7.1850,-5.0553,-0.3039,-0.0241},
				{0.0200,24.9761,5.5416,18.6083,6.9162,-4.9390,0.2859,18.5700,7.0000,-5.0000,0.0000,18.5317,7.0838,-5.0610,-0.2859,-0.0231},
				{0.0200,25.1141,5.5385,18.7447,6.8175,-4.9336,0.2680,18.7080,6.9000,-5.0000,0.0000,18.6713,6.9825,-5.0664,-0.2680,-0.0221},
				{0.0200,25.2501,5.5355,18.8791,6.7189,-4.9286,0.2501,18.8440,6.8000,-5.0000,0.0000,18.8089,6.8811,-5.0714,-0.2501,-0.0211},
				{0.0200,25.3840,5.5328,19.0115,6.6205,-4.9240,0.2322,18.9780,6.7000,-5.0000,0.0000,18.9445,6.7795,-5.0760,-0.2322,-0.0202},
				{0.0200,25.5160,5.5302,19.1419,6.5221,-4.9197,0.2145,19.1100,6.6000,-5.0000,0.0000,19.0781,6.6779,-5.0803,-0.2145,-0.0192},
				{0.0200,25.6460,5.5277,19.2704,6.4237,-4.9158,0.1969,19.2400,6.5000,-5.0000,0.0000,19.2096,6.5763,-5.0842,-0.1969,-0.0183},
				{0.0200,25.7740,5.5255,19.3969,6.3255,-4.9122,0.1795,19.3680,6.4000,-5.0000,0.0000,19.3391,6.4745,-5.0878,-0.1795,-0.0174},
				{0.0200,25.9000,5.5233,19.5214,6.2273,-4.9089,0.1623,19.4940,6.3000,-5.0000,0.0000,19.4666,6.3727,-5.0911,-0.1623,-0.0165},
				{0.0200,26.0239,5.5213,19.6440,6.1292,-4.9060,0.1454,19.6180,6.2000,-5.0000,0.0000,19.5920,6.2708,-5.0940,-0.1454,-0.0157},
				{0.0200,26.1459,5.5195,19.7646,6.0311,-4.9034,0.1288,19.7400,6.1000,-5.0000,0.0000,19.7154,6.1689,-5.0966,-0.1288,-0.0148},
				{0.0200,26.2659,5.5177,19.8833,5.9331,-4.9012,0.1124,19.8600,6.0000,-5.0000,0.0000,19.8367,6.0669,-5.0988,-0.1124,-0.0140},
				{0.0200,26.3839,5.5161,20.0000,5.8351,-4.8993,0.0964,19.9780,5.9000,-5.0000,0.0000,19.9560,5.9649,-5.1007,-0.0964,-0.0133},
				{0.0200,26.4999,5.5146,20.1147,5.7372,-4.8977,0.0808,20.0940,5.8000,-5.0000,0.0000,20.0733,5.8628,-5.1023,-0.0808,-0.0125},
				{0.0200,26.6139,5.5132,20.2275,5.6392,-4.8963,0.0655,20.2080,5.7000,-5.0000,0.0000,20.1885,5.7608,-5.1037,-0.0655,-0.0118},
				{0.0200,26.7259,5.5120,20.3384,5.5413,-4.8953,0.0506,20.3200,5.6000,-5.0000,0.0000,20.3016,5.6587,-5.1047,-0.0506,-0.0111},
				{0.0200,26.8359,5.5108,20.4472,5.4434,-4.8946,0.0362,20.4300,5.5000,-5.0000,0.0000,20.4128,5.5566,-5.1054,-0.0362,-0.0104},
				{0.0200,26.9439,5.5097,20.5541,5.3456,-4.8942,0.0222,20.5380,5.4000,-5.0000,0.0000,20.5219,5.4544,-5.1058,-0.0222,-0.0097},
				{0.0200,27.0499,5.5087,20.6591,5.2477,-4.8940,0.0087,20.6440,5.3000,-5.0000,0.0000,20.6289,5.3523,-5.1060,-0.0087,-0.0091},
				{0.0200,27.1539,5.5078,20.7621,5.1498,-4.8941,-0.0044,20.7480,5.2000,-5.0000,0.0000,20.7339,5.2502,-5.1059,0.0044,-0.0085},
				{0.0200,27.2559,5.5069,20.8631,5.0519,-4.8944,-0.0169,20.8500,5.1000,-5.0000,0.0000,20.8369,5.1481,-5.1056,0.0169,-0.0079},
				{0.0200,27.3559,5.5062,20.9622,4.9540,-4.8950,-0.0290,20.9500,5.0000,-5.0000,0.0000,20.9378,5.0460,-5.1050,0.0290,-0.0074},
				{0.0200,27.4538,5.5055,21.0593,4.8561,-4.8958,-0.0406,21.0480,4.9000,-5.0000,0.0000,21.0367,4.9439,-5.1042,0.0406,-0.0068},
				{0.0200,27.5498,5.5049,21.1545,4.7582,-4.8968,-0.0516,21.1440,4.8000,-5.0000,0.0000,21.1335,4.8418,-5.1032,0.0516,-0.0063},
				{0.0200,27.6438,5.5043,21.2477,4.6602,-4.8981,-0.0621,21.2380,4.7000,-5.0000,0.0000,21.2283,4.7398,-5.1019,0.0621,-0.0058},
				{0.0200,27.7358,5.5038,21.3389,4.5622,-4.8995,-0.0720,21.3300,4.6000,-5.0000,0.0000,21.3211,4.6378,-5.1005,0.0720,-0.0054},
				{0.0200,27.8258,5.5033,21.4282,4.4642,-4.9011,-0.0814,21.4200,4.5000,-5.0000,0.0000,21.4118,4.5358,-5.0989,0.0814,-0.0050},
				{0.0200,27.9138,5.5029,21.5155,4.3661,-4.9030,-0.0902,21.5080,4.4000,-5.0000,0.0000,21.5005,4.4339,-5.0970,0.0902,-0.0045},
				{0.0200,27.9998,5.5025,21.6009,4.2680,-4.9049,-0.0985,21.5940,4.3000,-5.0000,0.0000,21.5871,4.3320,-5.0951,0.0985,-0.0042},
				{0.0200,28.0838,5.5022,21.6843,4.1699,-4.9071,-0.1063,21.6780,4.2000,-5.0000,0.0000,21.6717,4.2301,-5.0929,0.1063,-0.0038},
				{0.0200,28.1658,5.5019,21.7657,4.0717,-4.9093,-0.1134,21.7600,4.1000,-5.0000,0.0000,21.7543,4.1283,-5.0907,0.1134,-0.0035},
				{0.0200,28.2458,5.5016,21.8452,3.9735,-4.9117,-0.1200,21.8400,4.0000,-5.0000,0.0000,21.8348,4.0265,-5.0883,0.1200,-0.0031},
				{0.0200,28.3238,5.5014,21.9227,3.8752,-4.9142,-0.1260,21.9180,3.9000,-5.0000,0.0000,21.9133,3.9248,-5.0858,0.1260,-0.0028},
				{0.0200,28.3998,5.5012,21.9983,3.7768,-4.9169,-0.1315,21.9940,3.8000,-5.0000,0.0000,21.9897,3.8232,-5.0831,0.1315,-0.0026},
				{0.0200,28.4738,5.5010,22.0718,3.6785,-4.9196,-0.1364,22.0680,3.7000,-5.0000,0.0000,22.0642,3.7215,-5.0804,0.1364,-0.0023},
				{0.0200,28.5458,5.5008,22.1434,3.5800,-4.9224,-0.1407,22.1400,3.6000,-5.0000,0.0000,22.1366,3.6200,-5.0776,0.1407,-0.0021},
				{0.0200,28.6158,5.5007,22.2130,3.4815,-4.9253,-0.1445,22.2100,3.5000,-5.0000,0.0000,22.2069,3.5185,-5.0747,0.1445,-0.0018},
				{0.0200,28.6838,5.5006,22.2807,3.3829,-4.9283,-0.1478,22.2780,3.4000,-5.0000,0.0000,22.2753,3.4171,-5.0717,0.1478,-0.0016},
				{0.0200,28.7498,5.5005,22.3464,3.2843,-4.9313,-0.1505,22.3440,3.3000,-5.0000,0.0000,22.3416,3.3157,-5.0687,0.1505,-0.0014},
				{0.0200,28.8138,5.5004,22.4101,3.1856,-4.9343,-0.1526,22.4080,3.2000,-5.0000,0.0000,22.4059,3.2144,-5.0657,0.1526,-0.0013},
				{0.0200,28.8758,5.5003,22.4718,3.0869,-4.9374,-0.1542,22.4700,3.1000,-5.0000,0.0000,22.4682,3.1131,-5.0626,0.1542,-0.0011},
				{0.0200,28.9358,5.5003,22.5316,2.9881,-4.9405,-0.1553,22.5300,3.0000,-5.0000,0.0000,22.5284,3.0119,-5.0595,0.1553,-0.0010},
				{0.0200,28.9938,5.5002,22.5894,2.8892,-4.9436,-0.1559,22.5880,2.9000,-5.0000,0.0000,22.5866,2.9108,-5.0564,0.1559,-0.0008},
				{0.0200,29.0498,5.5002,22.6452,2.7903,-4.9467,-0.1560,22.6440,2.8000,-5.0000,0.0000,22.6428,2.8097,-5.0533,0.1560,-0.0007},
				{0.0200,29.1038,5.5001,22.6990,2.6913,-4.9499,-0.1555,22.6980,2.7000,-5.0000,0.0000,22.6970,2.7087,-5.0501,0.1555,-0.0006},
				{0.0200,29.1558,5.5001,22.7509,2.5922,-4.9530,-0.1546,22.7500,2.6000,-5.0000,0.0000,22.7491,2.6078,-5.0470,0.1546,-0.0005},
				{0.0200,29.2058,5.5001,22.8007,2.4931,-4.9560,-0.1532,22.8000,2.5000,-5.0000,0.0000,22.7993,2.5069,-5.0440,0.1532,-0.0004},
				{0.0200,29.2538,5.5001,22.8486,2.3939,-4.9590,-0.1514,22.8480,2.4000,-5.0000,0.0000,22.8474,2.4061,-5.0410,0.1514,-0.0004},
				{0.0200,29.2998,5.5000,22.8945,2.2947,-4.9620,-0.1491,22.8940,2.3000,-5.0000,0.0000,22.8935,2.3053,-5.0380,0.1491,-0.0003},
				{0.0200,29.3438,5.5000,22.9384,2.1954,-4.9650,-0.1463,22.9380,2.2000,-5.0000,0.0000,22.9376,2.2046,-5.0350,0.1463,-0.0002},
				{0.0200,29.3858,5.5000,22.9803,2.0960,-4.9678,-0.1432,22.9800,2.1000,-5.0000,0.0000,22.9797,2.1040,-5.0322,0.1432,-0.0002},
				{0.0200,29.4258,5.5000,23.0203,1.9966,-4.9706,-0.1396,23.0200,2.0000,-5.0000,0.0000,23.0197,2.0034,-5.0294,0.1396,-0.0002},
				{0.0200,29.4638,5.5000,23.0582,1.8971,-4.9733,-0.1356,23.0580,1.9000,-5.0000,0.0000,23.0578,1.9029,-5.0267,0.1356,-0.0001},
				{0.0200,29.4998,5.5000,23.0941,1.7976,-4.9759,-0.1313,23.0940,1.8000,-5.0000,0.0000,23.0938,1.8024,-5.0241,0.1313,-0.0001},
				{0.0200,29.5338,5.5000,23.1281,1.6980,-4.9785,-0.1266,23.1280,1.7000,-5.0000,0.0000,23.1279,1.7020,-5.0215,0.1266,-0.0001},
				{0.0200,29.5658,5.5000,23.1601,1.5984,-4.9809,-0.1215,23.1600,1.6000,-5.0000,0.0000,23.1599,1.6016,-5.0191,0.1215,-0.0000},
				{0.0200,29.5958,5.5000,23.1901,1.4988,-4.9832,-0.1161,23.1900,1.5000,-5.0000,0.0000,23.1899,1.5012,-5.0168,0.1161,-0.0000},
				{0.0200,29.6238,5.5000,23.2180,1.3990,-4.9854,-0.1104,23.2180,1.4000,-5.0000,0.0000,23.2180,1.4010,-5.0146,0.1104,-0.0000},
				{0.0200,29.6498,5.5000,23.2440,1.2993,-4.9875,-0.1044,23.2440,1.3000,-5.0000,0.0000,23.2440,1.3007,-5.0125,0.1044,-0.0000},
				{0.0200,29.6738,5.5000,23.2680,1.1995,-4.9895,-0.0981,23.2680,1.2000,-5.0000,0.0000,23.2680,1.2005,-5.0105,0.0981,-0.0000},
				{0.0200,29.6958,5.5000,23.2900,1.0997,-4.9913,-0.0916,23.2900,1.1000,-5.0000,0.0000,23.2900,1.1003,-5.0087,0.0916,-0.0000},
				{0.0200,29.7158,5.5000,23.3100,0.9998,-4.9930,-0.0848,23.3100,1.0000,-5.0000,0.0000,23.3100,1.0002,-5.0070,0.0848,-0.0000},
				{0.0200,29.7338,5.5000,23.3280,0.8999,-4.9946,-0.0778,23.3280,0.9000,-5.0000,0.0000,23.3280,0.9001,-5.0054,0.0778,-0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.3081,-29.5909,-1229.8155,23.3342,0.8000,-5.0000,0.0000,23.3342,0.3081,-29.5976,-1229.6097,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,-15.4055,709.2692,23.3342,0.7000,-5.0000,0.0000,23.3342,0.0000,-15.4060,709.5813,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,770.2748,23.3342,0.6000,-5.0000,0.0000,23.3342,0.0000,0.0000,770.3000,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,0.0000,23.3342,0.5000,-5.0000,0.0000,23.3342,0.0000,0.0000,0.0000,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,0.0000,23.3342,0.4000,-5.0000,0.0000,23.3342,0.0000,0.0000,0.0000,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,0.0000,23.3342,0.3000,-5.0000,0.0000,23.3342,0.0000,0.0000,0.0000,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,0.0000,23.3342,0.2000,-5.0000,0.0000,23.3342,0.0000,0.0000,0.0000,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,0.0000,23.3342,0.1000,-5.0000,0.0000,23.3342,0.0000,0.0000,0.0000,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,0.0000,23.3342,0.0000,-5.0000,0.0000,23.3342,0.0000,0.0000,0.0000,0.0000},
				{0.0200,29.7400,5.5000,23.3342,0.0000,0.0000,0.0000,23.3342,-0.1000,-5.0000,0.0000,23.3342,0.0000,0.0000,0.0000,0.0000},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}