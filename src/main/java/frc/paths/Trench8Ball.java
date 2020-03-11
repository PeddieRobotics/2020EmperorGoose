package frc.paths;

import com.team319.trajectory.Path;

public class Trench8Ball extends Path {
   // dt,x,y,left.pos,left.vel,left.acc,left.jerk,center.pos,center.vel,center.acc,center.jerk,right.pos,right.vel,right.acc,right.jerk,heading
	private static final double[][] points = {
				{0.0200,30.8680,-11.4000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,0.0020,0.1000,5.0000,0.0000,3.1416},
				{0.0200,30.8640,-11.4000,0.0060,0.2000,5.0000,0.0000,0.0060,0.2000,5.0000,0.0000,0.0060,0.2000,5.0000,0.0000,3.1416},
				{0.0200,30.8580,-11.4000,0.0120,0.3000,5.0000,-0.0000,0.0120,0.3000,5.0000,0.0000,0.0120,0.3000,5.0000,-0.0000,3.1416},
				{0.0200,30.8500,-11.4000,0.0200,0.4000,5.0000,0.0000,0.0200,0.4000,5.0000,0.0000,0.0200,0.4000,5.0000,0.0000,3.1416},
				{0.0200,30.8400,-11.4000,0.0300,0.5000,5.0000,0.0000,0.0300,0.5000,5.0000,0.0000,0.0300,0.5000,5.0000,0.0000,3.1416},
				{0.0200,30.8280,-11.4000,0.0420,0.6000,5.0000,-0.0000,0.0420,0.6000,5.0000,0.0000,0.0420,0.6000,5.0000,-0.0000,3.1416},
				{0.0200,30.8140,-11.4000,0.0560,0.7000,5.0000,0.0000,0.0560,0.7000,5.0000,0.0000,0.0560,0.7000,5.0000,0.0000,3.1416},
				{0.0200,30.7980,-11.4000,0.0720,0.8000,5.0000,0.0000,0.0720,0.8000,5.0000,0.0000,0.0720,0.8000,5.0000,0.0000,3.1416},
				{0.0200,30.7800,-11.4000,0.0900,0.9000,5.0000,0.0000,0.0900,0.9000,5.0000,0.0000,0.0900,0.9000,5.0000,0.0000,3.1416},
				{0.0200,30.7600,-11.4000,0.1100,1.0000,5.0000,0.0000,0.1100,1.0000,5.0000,0.0000,0.1100,1.0000,5.0000,0.0000,3.1416},
				{0.0200,30.7380,-11.4000,0.1320,1.1000,5.0000,-0.0000,0.1320,1.1000,5.0000,0.0000,0.1320,1.1000,5.0000,-0.0000,3.1416},
				{0.0200,30.7140,-11.4000,0.1560,1.2000,5.0000,0.0000,0.1560,1.2000,5.0000,0.0000,0.1560,1.2000,5.0000,0.0000,3.1416},
				{0.0200,30.6880,-11.4000,0.1820,1.3000,5.0000,0.0000,0.1820,1.3000,5.0000,0.0000,0.1820,1.3000,5.0000,0.0000,3.1416},
				{0.0200,30.6600,-11.4000,0.2100,1.4000,5.0000,-0.0000,0.2100,1.4000,5.0000,0.0000,0.2100,1.4000,5.0000,-0.0000,3.1416},
				{0.0200,30.6300,-11.4000,0.2400,1.5000,5.0000,0.0000,0.2400,1.5000,5.0000,0.0000,0.2400,1.5000,5.0000,0.0000,3.1416},
				{0.0200,30.5980,-11.4000,0.2720,1.6000,5.0000,0.0000,0.2720,1.6000,5.0000,0.0000,0.2720,1.6000,5.0000,0.0000,3.1416},
				{0.0200,30.5640,-11.4000,0.3060,1.7000,5.0000,-0.0000,0.3060,1.7000,5.0000,0.0000,0.3060,1.7000,5.0000,-0.0000,3.1416},
				{0.0200,30.5280,-11.4000,0.3420,1.8000,5.0000,0.0000,0.3420,1.8000,5.0000,0.0000,0.3420,1.8000,5.0000,0.0000,3.1416},
				{0.0200,30.4900,-11.4000,0.3800,1.9000,5.0000,0.0000,0.3800,1.9000,5.0000,0.0000,0.3800,1.9000,5.0000,0.0000,3.1416},
				{0.0200,30.4500,-11.4000,0.4200,2.0000,5.0000,-0.0000,0.4200,2.0000,5.0000,0.0000,0.4200,2.0000,5.0000,-0.0000,3.1416},
				{0.0200,30.4080,-11.4000,0.4620,2.1000,5.0000,0.0000,0.4620,2.1000,5.0000,0.0000,0.4620,2.1000,5.0000,0.0000,3.1416},
				{0.0200,30.3640,-11.4000,0.5060,2.2000,5.0000,0.0000,0.5060,2.2000,5.0000,0.0000,0.5060,2.2000,5.0000,0.0000,3.1416},
				{0.0200,30.3180,-11.4000,0.5520,2.3000,5.0000,-0.0000,0.5520,2.3000,5.0000,0.0000,0.5520,2.3000,5.0000,-0.0000,3.1416},
				{0.0200,30.2700,-11.4000,0.6000,2.4000,5.0000,0.0000,0.6000,2.4000,5.0000,0.0000,0.6000,2.4000,5.0000,0.0000,3.1416},
				{0.0200,30.2200,-11.4000,0.6500,2.5000,5.0000,-0.0000,0.6500,2.5000,5.0000,0.0000,0.6500,2.5000,5.0000,-0.0000,3.1416},
				{0.0200,30.1680,-11.4000,0.7020,2.6000,5.0000,0.0000,0.7020,2.6000,5.0000,0.0000,0.7020,2.6000,5.0000,0.0000,3.1416},
				{0.0200,30.1140,-11.4000,0.7560,2.7000,5.0000,-0.0000,0.7560,2.7000,5.0000,0.0000,0.7560,2.7000,5.0000,-0.0000,3.1416},
				{0.0200,30.0580,-11.4000,0.8120,2.8000,5.0000,0.0000,0.8120,2.8000,5.0000,0.0000,0.8120,2.8000,5.0000,0.0000,3.1416},
				{0.0200,30.0000,-11.4000,0.8700,2.9000,5.0000,0.0000,0.8700,2.9000,5.0000,0.0000,0.8700,2.9000,5.0000,0.0000,3.1416},
				{0.0200,29.9400,-11.4000,0.9300,3.0000,5.0000,0.0000,0.9300,3.0000,5.0000,0.0000,0.9300,3.0000,5.0000,0.0000,3.1416},
				{0.0200,29.8780,-11.4000,0.9920,3.1000,5.0000,0.0000,0.9920,3.1000,5.0000,0.0000,0.9920,3.1000,5.0000,0.0000,3.1416},
				{0.0200,29.8140,-11.4000,1.0560,3.2000,5.0000,0.0000,1.0560,3.2000,5.0000,0.0000,1.0560,3.2000,5.0000,0.0000,3.1416},
				{0.0200,29.7480,-11.4000,1.1220,3.3000,5.0000,-0.0000,1.1220,3.3000,5.0000,0.0000,1.1220,3.3000,5.0000,-0.0000,3.1416},
				{0.0200,29.6800,-11.4000,1.1900,3.4000,5.0000,0.0000,1.1900,3.4000,5.0000,0.0000,1.1900,3.4000,5.0000,0.0000,3.1416},
				{0.0200,29.6100,-11.4000,1.2600,3.5000,5.0000,0.0000,1.2600,3.5000,5.0000,0.0000,1.2600,3.5000,5.0000,0.0000,3.1416},
				{0.0200,29.5380,-11.4000,1.3320,3.6000,5.0000,-0.0000,1.3320,3.6000,5.0000,0.0000,1.3320,3.6000,5.0000,-0.0000,3.1416},
				{0.0200,29.4640,-11.4000,1.4060,3.7000,5.0000,-0.0000,1.4060,3.7000,5.0000,0.0000,1.4060,3.7000,5.0000,-0.0000,3.1416},
				{0.0200,29.3880,-11.4000,1.4820,3.8000,5.0000,-0.0000,1.4820,3.8000,5.0000,0.0000,1.4820,3.8000,5.0000,-0.0000,3.1416},
				{0.0200,29.3100,-11.4000,1.5600,3.9000,5.0000,0.0000,1.5600,3.9000,5.0000,0.0000,1.5600,3.9000,5.0000,0.0000,3.1416},
				{0.0200,29.2300,-11.4000,1.6400,4.0000,5.0000,-0.0000,1.6400,4.0000,5.0000,0.0000,1.6400,4.0000,5.0000,-0.0000,3.1416},
				{0.0200,29.1480,-11.4000,1.7220,4.1000,5.0000,0.0000,1.7220,4.1000,5.0000,0.0000,1.7220,4.1000,5.0000,0.0000,3.1416},
				{0.0200,29.0640,-11.4000,1.8060,4.2000,5.0000,-0.0000,1.8060,4.2000,5.0000,0.0000,1.8060,4.2000,5.0000,-0.0000,3.1416},
				{0.0200,28.9780,-11.4000,1.8920,4.3000,5.0000,0.0000,1.8920,4.3000,5.0000,0.0000,1.8920,4.3000,5.0000,0.0000,3.1416},
				{0.0200,28.8900,-11.4000,1.9800,4.4000,5.0000,-0.0000,1.9800,4.4000,5.0000,0.0000,1.9800,4.4000,5.0000,-0.0000,3.1416},
				{0.0200,28.8000,-11.4000,2.0700,4.5000,5.0000,0.0000,2.0700,4.5000,5.0000,0.0000,2.0700,4.5000,5.0000,0.0000,3.1416},
				{0.0200,28.7080,-11.4000,2.1620,4.6000,5.0000,0.0000,2.1620,4.6000,5.0000,0.0000,2.1620,4.6000,5.0000,0.0000,3.1416},
				{0.0200,28.6140,-11.4000,2.2560,4.7000,5.0000,-0.0000,2.2560,4.7000,5.0000,0.0000,2.2560,4.7000,5.0000,-0.0000,3.1416},
				{0.0200,28.5180,-11.4000,2.3520,4.8000,5.0000,0.0000,2.3520,4.8000,5.0000,0.0000,2.3520,4.8000,5.0000,0.0000,3.1416},
				{0.0200,28.4200,-11.4000,2.4500,4.9000,5.0000,-0.0000,2.4500,4.9000,5.0000,0.0000,2.4500,4.9000,5.0000,-0.0000,3.1416},
				{0.0200,28.3200,-11.4000,2.5500,5.0000,5.0000,-0.0000,2.5500,5.0000,5.0000,0.0000,2.5500,5.0000,5.0000,-0.0000,3.1416},
				{0.0200,28.2180,-11.4000,2.6520,5.1000,5.0000,0.0000,2.6520,5.1000,5.0000,0.0000,2.6520,5.1000,5.0000,0.0000,3.1416},
				{0.0200,28.1140,-11.4000,2.7560,5.2000,5.0000,0.0000,2.7560,5.2000,5.0000,0.0000,2.7560,5.2000,5.0000,0.0000,3.1416},
				{0.0200,28.0080,-11.4000,2.8620,5.3000,5.0000,0.0000,2.8620,5.3000,5.0000,0.0000,2.8620,5.3000,5.0000,0.0000,3.1416},
				{0.0200,27.9000,-11.4000,2.9700,5.4000,5.0000,0.0000,2.9700,5.4000,5.0000,0.0000,2.9700,5.4000,5.0000,0.0000,3.1416},
				{0.0200,27.7900,-11.4000,3.0800,5.5000,5.0000,-0.0000,3.0800,5.5000,5.0000,0.0000,3.0800,5.5000,5.0000,-0.0000,3.1416},
				{0.0200,27.6780,-11.4000,3.1920,5.6000,5.0000,0.0000,3.1920,5.6000,5.0000,0.0000,3.1920,5.6000,5.0000,0.0000,3.1416},
				{0.0200,27.5640,-11.4000,3.3060,5.7000,5.0000,-0.0000,3.3060,5.7000,5.0000,0.0000,3.3060,5.7000,5.0000,-0.0000,3.1416},
				{0.0200,27.4480,-11.4000,3.4220,5.8000,5.0000,0.0000,3.4220,5.8000,5.0000,0.0000,3.4220,5.8000,5.0000,0.0000,3.1416},
				{0.0200,27.3300,-11.4000,3.5400,5.9000,5.0000,-0.0000,3.5400,5.9000,5.0000,0.0000,3.5400,5.9000,5.0000,-0.0000,3.1416},
				{0.0200,27.2100,-11.4000,3.6600,6.0000,5.0000,0.0000,3.6600,6.0000,5.0000,0.0000,3.6600,6.0000,5.0000,0.0000,3.1416},
				{0.0200,27.0880,-11.4000,3.7820,6.1000,5.0000,0.0000,3.7820,6.1000,5.0000,0.0000,3.7820,6.1000,5.0000,0.0000,3.1416},
				{0.0200,26.9640,-11.4000,3.9060,6.2000,5.0000,-0.0000,3.9060,6.2000,5.0000,0.0000,3.9060,6.2000,5.0000,-0.0000,3.1416},
				{0.0200,26.8380,-11.4000,4.0320,6.3000,5.0000,0.0000,4.0320,6.3000,5.0000,0.0000,4.0320,6.3000,5.0000,0.0000,3.1416},
				{0.0200,26.7100,-11.4000,4.1600,6.4000,5.0000,0.0000,4.1600,6.4000,5.0000,0.0000,4.1600,6.4000,5.0000,0.0000,3.1416},
				{0.0200,26.5800,-11.4000,4.2900,6.5000,5.0000,0.0000,4.2900,6.5000,5.0000,0.0000,4.2900,6.5000,5.0000,0.0000,3.1416},
				{0.0200,26.4480,-11.4000,4.4220,6.6000,5.0000,-0.0000,4.4220,6.6000,5.0000,0.0000,4.4220,6.6000,5.0000,-0.0000,3.1416},
				{0.0200,26.3140,-11.4000,4.5560,6.7000,5.0000,0.0000,4.5560,6.7000,5.0000,0.0000,4.5560,6.7000,5.0000,0.0000,3.1416},
				{0.0200,26.1780,-11.4000,4.6920,6.8000,5.0000,0.0000,4.6920,6.8000,5.0000,0.0000,4.6920,6.8000,5.0000,0.0000,3.1416},
				{0.0200,26.0400,-11.4000,4.8300,6.9000,5.0000,0.0000,4.8300,6.9000,5.0000,0.0000,4.8300,6.9000,5.0000,0.0000,3.1416},
				{0.0200,25.9000,-11.4000,4.9700,7.0000,5.0000,-0.0000,4.9700,7.0000,5.0000,0.0000,4.9700,7.0000,5.0000,-0.0000,3.1416},
				{0.0200,25.7580,-11.4000,5.1120,7.1000,5.0000,0.0000,5.1120,7.1000,5.0000,0.0000,5.1120,7.1000,5.0000,0.0000,3.1416},
				{0.0200,25.6140,-11.4000,5.2560,7.2000,5.0000,0.0000,5.2560,7.2000,5.0000,0.0000,5.2560,7.2000,5.0000,0.0000,3.1416},
				{0.0200,25.4680,-11.4000,5.4020,7.3000,5.0000,0.0000,5.4020,7.3000,5.0000,0.0000,5.4020,7.3000,5.0000,0.0000,3.1416},
				{0.0200,25.3200,-11.4000,5.5500,7.4000,5.0000,-0.0000,5.5500,7.4000,5.0000,0.0000,5.5500,7.4000,5.0000,-0.0000,3.1416},
				{0.0200,25.1700,-11.4000,5.7000,7.5000,5.0000,0.0000,5.7000,7.5000,5.0000,0.0000,5.7000,7.5000,5.0000,0.0000,3.1416},
				{0.0200,25.0180,-11.4000,5.8520,7.6000,5.0000,0.0000,5.8520,7.6000,5.0000,0.0000,5.8520,7.6000,5.0000,0.0000,3.1416},
				{0.0200,24.8640,-11.4000,6.0060,7.7000,5.0000,0.0000,6.0060,7.7000,5.0000,0.0000,6.0060,7.7000,5.0000,0.0000,3.1416},
				{0.0200,24.7080,-11.4000,6.1620,7.8000,5.0000,-0.0000,6.1620,7.8000,5.0000,0.0000,6.1620,7.8000,5.0000,-0.0000,3.1416},
				{0.0200,24.5500,-11.4000,6.3200,7.9000,5.0000,0.0000,6.3200,7.9000,5.0000,0.0000,6.3200,7.9000,5.0000,0.0000,3.1416},
				{0.0200,24.3900,-11.4000,6.4800,8.0000,5.0000,0.0000,6.4800,8.0000,5.0000,0.0000,6.4800,8.0000,5.0000,0.0000,3.1416},
				{0.0200,24.2280,-11.4000,6.6420,8.1000,5.0000,0.0000,6.6420,8.1000,5.0000,0.0000,6.6420,8.1000,5.0000,0.0000,3.1416},
				{0.0200,24.0640,-11.4000,6.8060,8.2000,5.0000,-0.0000,6.8060,8.2000,5.0000,0.0000,6.8060,8.2000,5.0000,-0.0000,3.1416},
				{0.0200,23.8980,-11.4000,6.9720,8.3000,5.0000,0.0000,6.9720,8.3000,5.0000,0.0000,6.9720,8.3000,5.0000,0.0000,3.1416},
				{0.0200,23.7300,-11.4000,7.1400,8.4000,5.0000,0.0000,7.1400,8.4000,5.0000,0.0000,7.1400,8.4000,5.0000,0.0000,3.1416},
				{0.0200,23.5600,-11.4000,7.3100,8.5000,5.0000,-0.0000,7.3100,8.5000,5.0000,0.0000,7.3100,8.5000,5.0000,-0.0000,3.1416},
				{0.0200,23.3880,-11.4000,7.4820,8.6000,5.0000,0.0000,7.4820,8.6000,5.0000,0.0000,7.4820,8.6000,5.0000,0.0000,3.1416},
				{0.0200,23.2140,-11.4000,7.6560,8.7000,5.0000,-0.0000,7.6560,8.7000,5.0000,0.0000,7.6560,8.7000,5.0000,-0.0000,3.1416},
				{0.0200,23.0380,-11.4000,7.8320,8.8000,5.0000,0.0000,7.8320,8.8000,5.0000,0.0000,7.8320,8.8000,5.0000,0.0000,3.1416},
				{0.0200,22.8600,-11.4000,8.0100,8.9000,5.0000,-0.0000,8.0100,8.9000,5.0000,0.0000,8.0100,8.9000,5.0000,-0.0000,3.1416},
				{0.0200,22.6800,-11.4000,8.1900,9.0000,5.0000,-0.0000,8.1900,9.0000,5.0000,0.0000,8.1900,9.0000,5.0000,-0.0000,3.1416},
				{0.0200,22.4980,-11.4000,8.3720,9.1000,5.0000,0.0000,8.3720,9.1000,5.0000,0.0000,8.3720,9.1000,5.0000,0.0000,3.1416},
				{0.0200,22.3140,-11.4000,8.5560,9.2000,5.0000,0.0000,8.5560,9.2000,5.0000,0.0000,8.5560,9.2000,5.0000,0.0000,3.1416},
				{0.0200,22.1280,-11.4000,8.7420,9.3000,5.0000,-0.0000,8.7420,9.3000,5.0000,0.0000,8.7420,9.3000,5.0000,-0.0000,3.1416},
				{0.0200,21.9400,-11.4000,8.9300,9.4000,5.0000,0.0000,8.9300,9.4000,5.0000,0.0000,8.9300,9.4000,5.0000,0.0000,3.1416},
				{0.0200,21.7500,-11.4000,9.1200,9.5000,5.0000,-0.0000,9.1200,9.5000,5.0000,0.0000,9.1200,9.5000,5.0000,-0.0000,3.1416},
				{0.0200,21.5580,-11.4000,9.3120,9.6000,5.0000,0.0000,9.3120,9.6000,5.0000,0.0000,9.3120,9.6000,5.0000,0.0000,3.1416},
				{0.0200,21.3640,-11.4000,9.5060,9.7000,5.0000,-0.0000,9.5060,9.7000,5.0000,0.0000,9.5060,9.7000,5.0000,-0.0000,3.1416},
				{0.0200,21.1680,-11.4000,9.7020,9.8000,5.0000,0.0000,9.7020,9.8000,5.0000,0.0000,9.7020,9.8000,5.0000,0.0000,3.1416},
				{0.0200,20.9740,-11.4000,9.8960,9.7000,-5.0000,-500.0000,9.8960,9.7000,-5.0000,0.0000,9.8960,9.7000,-5.0000,-500.0000,3.1416},
				{0.0200,20.7820,-11.4000,10.0880,9.6000,-5.0000,-0.0000,10.0880,9.6000,-5.0000,0.0000,10.0880,9.6000,-5.0000,-0.0000,3.1416},
				{0.0200,20.5920,-11.4000,10.2780,9.5000,-5.0000,0.0000,10.2780,9.5000,-5.0000,0.0000,10.2780,9.5000,-5.0000,0.0000,3.1416},
				{0.0200,20.4040,-11.4000,10.4660,9.4000,-5.0000,-0.0000,10.4660,9.4000,-5.0000,0.0000,10.4660,9.4000,-5.0000,-0.0000,3.1416},
				{0.0200,20.2180,-11.4000,10.6520,9.3000,-5.0000,0.0000,10.6520,9.3000,-5.0000,0.0000,10.6520,9.3000,-5.0000,0.0000,3.1416},
				{0.0200,20.0340,-11.4000,10.8360,9.2000,-5.0000,-0.0000,10.8360,9.2000,-5.0000,0.0000,10.8360,9.2000,-5.0000,-0.0000,3.1416},
				{0.0200,19.8520,-11.4000,11.0180,9.1000,-5.0000,0.0000,11.0180,9.1000,-5.0000,0.0000,11.0180,9.1000,-5.0000,0.0000,3.1416},
				{0.0200,19.6720,-11.4000,11.1980,9.0000,-5.0000,0.0000,11.1980,9.0000,-5.0000,0.0000,11.1980,9.0000,-5.0000,0.0000,3.1416},
				{0.0200,19.4940,-11.4000,11.3760,8.9000,-5.0000,0.0000,11.3760,8.9000,-5.0000,0.0000,11.3760,8.9000,-5.0000,0.0000,3.1416},
				{0.0200,19.3180,-11.4000,11.5520,8.8000,-5.0000,-0.0000,11.5520,8.8000,-5.0000,0.0000,11.5520,8.8000,-5.0000,-0.0000,3.1416},
				{0.0200,19.1440,-11.4000,11.7260,8.7000,-5.0000,0.0000,11.7260,8.7000,-5.0000,0.0000,11.7260,8.7000,-5.0000,0.0000,3.1416},
				{0.0200,18.9720,-11.4000,11.8980,8.6000,-5.0000,-0.0000,11.8980,8.6000,-5.0000,0.0000,11.8980,8.6000,-5.0000,-0.0000,3.1416},
				{0.0200,18.8020,-11.4000,12.0680,8.5000,-5.0000,0.0000,12.0680,8.5000,-5.0000,0.0000,12.0680,8.5000,-5.0000,0.0000,3.1416},
				{0.0200,18.6340,-11.4000,12.2360,8.4000,-5.0000,-0.0000,12.2360,8.4000,-5.0000,0.0000,12.2360,8.4000,-5.0000,-0.0000,3.1416},
				{0.0200,18.4680,-11.4000,12.4020,8.3000,-5.0000,0.0000,12.4020,8.3000,-5.0000,0.0000,12.4020,8.3000,-5.0000,0.0000,3.1416},
				{0.0200,18.3040,-11.4000,12.5660,8.2000,-5.0000,-0.0000,12.5660,8.2000,-5.0000,0.0000,12.5660,8.2000,-5.0000,-0.0000,3.1416},
				{0.0200,18.1420,-11.4000,12.7280,8.1000,-5.0000,0.0000,12.7280,8.1000,-5.0000,0.0000,12.7280,8.1000,-5.0000,0.0000,3.1416},
				{0.0200,17.9820,-11.4000,12.8880,8.0000,-5.0000,0.0000,12.8880,8.0000,-5.0000,0.0000,12.8880,8.0000,-5.0000,0.0000,3.1416},
				{0.0200,17.8240,-11.4000,13.0460,7.9000,-5.0000,-0.0000,13.0460,7.9000,-5.0000,0.0000,13.0460,7.9000,-5.0000,-0.0000,3.1416},
				{0.0200,17.6680,-11.4000,13.2020,7.8000,-5.0000,0.0000,13.2020,7.8000,-5.0000,0.0000,13.2020,7.8000,-5.0000,0.0000,3.1416},
				{0.0200,17.5140,-11.4000,13.3560,7.7000,-5.0000,-0.0000,13.3560,7.7000,-5.0000,0.0000,13.3560,7.7000,-5.0000,-0.0000,3.1416},
				{0.0200,17.3620,-11.4000,13.5080,7.6000,-5.0000,0.0000,13.5080,7.6000,-5.0000,0.0000,13.5080,7.6000,-5.0000,0.0000,3.1416},
				{0.0200,17.2120,-11.4000,13.6580,7.5000,-5.0000,0.0000,13.6580,7.5000,-5.0000,0.0000,13.6580,7.5000,-5.0000,0.0000,3.1416},
				{0.0200,17.0640,-11.4000,13.8060,7.4000,-5.0000,0.0000,13.8060,7.4000,-5.0000,0.0000,13.8060,7.4000,-5.0000,0.0000,3.1416},
				{0.0200,16.9180,-11.4000,13.9520,7.3000,-5.0000,-0.0000,13.9520,7.3000,-5.0000,0.0000,13.9520,7.3000,-5.0000,-0.0000,3.1416},
				{0.0200,16.7740,-11.4000,14.0960,7.2000,-5.0000,0.0000,14.0960,7.2000,-5.0000,0.0000,14.0960,7.2000,-5.0000,0.0000,3.1416},
				{0.0200,16.6320,-11.4000,14.2380,7.1000,-5.0000,0.0000,14.2380,7.1000,-5.0000,0.0000,14.2380,7.1000,-5.0000,0.0000,3.1416},
				{0.0200,16.4920,-11.4000,14.3780,7.0000,-5.0000,-0.0000,14.3780,7.0000,-5.0000,0.0000,14.3780,7.0000,-5.0000,-0.0000,3.1416},
				{0.0200,16.3540,-11.4000,14.5160,6.9000,-5.0000,0.0000,14.5160,6.9000,-5.0000,0.0000,14.5160,6.9000,-5.0000,0.0000,3.1416},
				{0.0200,16.2180,-11.4000,14.6520,6.8000,-5.0000,-0.0000,14.6520,6.8000,-5.0000,0.0000,14.6520,6.8000,-5.0000,-0.0000,3.1416},
				{0.0200,16.0840,-11.4000,14.7860,6.7000,-5.0000,0.0000,14.7860,6.7000,-5.0000,0.0000,14.7860,6.7000,-5.0000,0.0000,3.1416},
				{0.0200,15.9520,-11.4000,14.9180,6.6000,-5.0000,-0.0000,14.9180,6.6000,-5.0000,0.0000,14.9180,6.6000,-5.0000,-0.0000,3.1416},
				{0.0200,15.8220,-11.4000,15.0480,6.5000,-5.0000,0.0000,15.0480,6.5000,-5.0000,0.0000,15.0480,6.5000,-5.0000,0.0000,3.1416},
				{0.0200,15.6940,-11.4000,15.1760,6.4000,-5.0000,0.0000,15.1760,6.4000,-5.0000,0.0000,15.1760,6.4000,-5.0000,0.0000,3.1416},
				{0.0200,15.5680,-11.4000,15.3020,6.3000,-5.0000,-0.0000,15.3020,6.3000,-5.0000,0.0000,15.3020,6.3000,-5.0000,-0.0000,3.1416},
				{0.0200,15.4440,-11.4000,15.4260,6.2000,-5.0000,0.0000,15.4260,6.2000,-5.0000,0.0000,15.4260,6.2000,-5.0000,0.0000,3.1416},
				{0.0200,15.3220,-11.4000,15.5480,6.1000,-5.0000,-0.0000,15.5480,6.1000,-5.0000,0.0000,15.5480,6.1000,-5.0000,-0.0000,3.1416},
				{0.0200,15.2020,-11.4000,15.6680,6.0000,-5.0000,0.0000,15.6680,6.0000,-5.0000,0.0000,15.6680,6.0000,-5.0000,0.0000,3.1416},
				{0.0200,15.0840,-11.4000,15.7860,5.9000,-5.0000,0.0000,15.7860,5.9000,-5.0000,0.0000,15.7860,5.9000,-5.0000,0.0000,3.1416},
				{0.0200,14.9680,-11.4000,15.9020,5.8000,-5.0000,-0.0000,15.9020,5.8000,-5.0000,0.0000,15.9020,5.8000,-5.0000,-0.0000,3.1416},
				{0.0200,14.8540,-11.4000,16.0160,5.7000,-5.0000,-0.0000,16.0160,5.7000,-5.0000,0.0000,16.0160,5.7000,-5.0000,-0.0000,3.1416},
				{0.0200,14.7420,-11.4000,16.1280,5.6000,-5.0000,0.0000,16.1280,5.6000,-5.0000,0.0000,16.1280,5.6000,-5.0000,0.0000,3.1416},
				{0.0200,14.6320,-11.4000,16.2380,5.5000,-5.0000,-0.0000,16.2380,5.5000,-5.0000,0.0000,16.2380,5.5000,-5.0000,-0.0000,3.1416},
				{0.0200,14.5240,-11.4000,16.3460,5.4000,-5.0000,-0.0000,16.3460,5.4000,-5.0000,0.0000,16.3460,5.4000,-5.0000,-0.0000,3.1416},
				{0.0200,14.4180,-11.4000,16.4520,5.3000,-5.0000,0.0000,16.4520,5.3000,-5.0000,0.0000,16.4520,5.3000,-5.0000,0.0000,3.1416},
				{0.0200,14.3140,-11.4000,16.5560,5.2000,-5.0000,-0.0000,16.5560,5.2000,-5.0000,0.0000,16.5560,5.2000,-5.0000,-0.0000,3.1416},
				{0.0200,14.2120,-11.4000,16.6580,5.1000,-5.0000,0.0000,16.6580,5.1000,-5.0000,0.0000,16.6580,5.1000,-5.0000,0.0000,3.1416},
				{0.0200,14.1120,-11.4000,16.7580,5.0000,-5.0000,-0.0000,16.7580,5.0000,-5.0000,0.0000,16.7580,5.0000,-5.0000,-0.0000,3.1416},
				{0.0200,14.0140,-11.4000,16.8560,4.9000,-5.0000,-0.0000,16.8560,4.9000,-5.0000,0.0000,16.8560,4.9000,-5.0000,-0.0000,3.1416},
				{0.0200,13.9180,-11.4000,16.9520,4.8000,-5.0000,0.0000,16.9520,4.8000,-5.0000,0.0000,16.9520,4.8000,-5.0000,0.0000,3.1416},
				{0.0200,13.8240,-11.4000,17.0460,4.7000,-5.0000,0.0000,17.0460,4.7000,-5.0000,0.0000,17.0460,4.7000,-5.0000,0.0000,3.1416},
				{0.0200,13.7320,-11.4000,17.1380,4.6000,-5.0000,-0.0000,17.1380,4.6000,-5.0000,0.0000,17.1380,4.6000,-5.0000,-0.0000,3.1416},
				{0.0200,13.6420,-11.4000,17.2280,4.5000,-5.0000,0.0000,17.2280,4.5000,-5.0000,0.0000,17.2280,4.5000,-5.0000,0.0000,3.1416},
				{0.0200,13.5540,-11.4000,17.3160,4.4000,-5.0000,0.0000,17.3160,4.4000,-5.0000,0.0000,17.3160,4.4000,-5.0000,0.0000,3.1416},
				{0.0200,13.4680,-11.4000,17.4020,4.3000,-5.0000,-0.0000,17.4020,4.3000,-5.0000,0.0000,17.4020,4.3000,-5.0000,-0.0000,3.1416},
				{0.0200,13.3840,-11.4000,17.4860,4.2000,-5.0000,0.0000,17.4860,4.2000,-5.0000,0.0000,17.4860,4.2000,-5.0000,0.0000,3.1416},
				{0.0200,13.3020,-11.4000,17.5680,4.1000,-5.0000,0.0000,17.5680,4.1000,-5.0000,0.0000,17.5680,4.1000,-5.0000,0.0000,3.1416},
				{0.0200,13.2220,-11.4000,17.6480,4.0000,-5.0000,-0.0000,17.6480,4.0000,-5.0000,0.0000,17.6480,4.0000,-5.0000,-0.0000,3.1416},
				{0.0200,13.1440,-11.4000,17.7260,3.9000,-5.0000,-0.0000,17.7260,3.9000,-5.0000,0.0000,17.7260,3.9000,-5.0000,-0.0000,3.1416},
				{0.0200,13.0680,-11.4000,17.8020,3.8000,-5.0000,0.0000,17.8020,3.8000,-5.0000,0.0000,17.8020,3.8000,-5.0000,0.0000,3.1416},
				{0.0200,12.9940,-11.4000,17.8760,3.7000,-5.0000,-0.0000,17.8760,3.7000,-5.0000,0.0000,17.8760,3.7000,-5.0000,-0.0000,3.1416},
				{0.0200,12.9220,-11.4000,17.9480,3.6000,-5.0000,-0.0000,17.9480,3.6000,-5.0000,0.0000,17.9480,3.6000,-5.0000,-0.0000,3.1416},
				{0.0200,12.8520,-11.4000,18.0180,3.5000,-5.0000,0.0000,18.0180,3.5000,-5.0000,0.0000,18.0180,3.5000,-5.0000,0.0000,3.1416},
				{0.0200,12.7840,-11.4000,18.0860,3.4000,-5.0000,-0.0000,18.0860,3.4000,-5.0000,0.0000,18.0860,3.4000,-5.0000,-0.0000,3.1416},
				{0.0200,12.7180,-11.4000,18.1520,3.3000,-5.0000,0.0000,18.1520,3.3000,-5.0000,0.0000,18.1520,3.3000,-5.0000,0.0000,3.1416},
				{0.0200,12.6540,-11.4000,18.2160,3.2000,-5.0000,-0.0000,18.2160,3.2000,-5.0000,0.0000,18.2160,3.2000,-5.0000,-0.0000,3.1416},
				{0.0200,12.5920,-11.4000,18.2780,3.1000,-5.0000,0.0000,18.2780,3.1000,-5.0000,0.0000,18.2780,3.1000,-5.0000,0.0000,3.1416},
				{0.0200,12.5320,-11.4000,18.3380,3.0000,-5.0000,-0.0000,18.3380,3.0000,-5.0000,0.0000,18.3380,3.0000,-5.0000,-0.0000,3.1416},
				{0.0200,12.4740,-11.4000,18.3960,2.9000,-5.0000,0.0000,18.3960,2.9000,-5.0000,0.0000,18.3960,2.9000,-5.0000,0.0000,3.1416},
				{0.0200,12.4180,-11.4000,18.4520,2.8000,-5.0000,0.0000,18.4520,2.8000,-5.0000,0.0000,18.4520,2.8000,-5.0000,0.0000,3.1416},
				{0.0200,12.3640,-11.4000,18.5060,2.7000,-5.0000,-0.0000,18.5060,2.7000,-5.0000,0.0000,18.5060,2.7000,-5.0000,-0.0000,3.1416},
				{0.0200,12.3120,-11.4000,18.5580,2.6000,-5.0000,0.0000,18.5580,2.6000,-5.0000,0.0000,18.5580,2.6000,-5.0000,0.0000,3.1416},
				{0.0200,12.2620,-11.4000,18.6080,2.5000,-5.0000,-0.0000,18.6080,2.5000,-5.0000,0.0000,18.6080,2.5000,-5.0000,-0.0000,3.1416},
				{0.0200,12.2140,-11.4000,18.6560,2.4000,-5.0000,0.0000,18.6560,2.4000,-5.0000,0.0000,18.6560,2.4000,-5.0000,0.0000,3.1416},
				{0.0200,12.1680,-11.4000,18.7020,2.3000,-5.0000,-0.0000,18.7020,2.3000,-5.0000,0.0000,18.7020,2.3000,-5.0000,-0.0000,3.1416},
				{0.0200,12.1240,-11.4000,18.7460,2.2000,-5.0000,0.0000,18.7460,2.2000,-5.0000,0.0000,18.7460,2.2000,-5.0000,0.0000,3.1416},
				{0.0200,12.0820,-11.4000,18.7880,2.1000,-5.0000,-0.0000,18.7880,2.1000,-5.0000,0.0000,18.7880,2.1000,-5.0000,-0.0000,3.1416},
				{0.0200,12.0420,-11.4000,18.8280,2.0000,-5.0000,0.0000,18.8280,2.0000,-5.0000,0.0000,18.8280,2.0000,-5.0000,0.0000,3.1416},
				{0.0200,12.0040,-11.4000,18.8660,1.9000,-5.0000,0.0000,18.8660,1.9000,-5.0000,0.0000,18.8660,1.9000,-5.0000,0.0000,3.1416},
				{0.0200,11.9680,-11.4000,18.9020,1.8000,-5.0000,-0.0000,18.9020,1.8000,-5.0000,0.0000,18.9020,1.8000,-5.0000,-0.0000,3.1416},
				{0.0200,11.9340,-11.4000,18.9360,1.7000,-5.0000,0.0000,18.9360,1.7000,-5.0000,0.0000,18.9360,1.7000,-5.0000,0.0000,3.1416},
				{0.0200,11.9020,-11.4000,18.9680,1.6000,-5.0000,0.0000,18.9680,1.6000,-5.0000,0.0000,18.9680,1.6000,-5.0000,0.0000,3.1416},
				{0.0200,11.8720,-11.4000,18.9980,1.5000,-5.0000,0.0000,18.9980,1.5000,-5.0000,0.0000,18.9980,1.5000,-5.0000,0.0000,3.1416},
				{0.0200,11.8440,-11.4000,19.0260,1.4000,-5.0000,0.0000,19.0260,1.4000,-5.0000,0.0000,19.0260,1.4000,-5.0000,0.0000,3.1416},
				{0.0200,11.8180,-11.4000,19.0520,1.3000,-5.0000,0.0000,19.0520,1.3000,-5.0000,0.0000,19.0520,1.3000,-5.0000,0.0000,3.1416},
				{0.0200,11.7940,-11.4000,19.0760,1.2000,-5.0000,-0.0000,19.0760,1.2000,-5.0000,0.0000,19.0760,1.2000,-5.0000,-0.0000,3.1416},
				{0.0200,11.7720,-11.4000,19.0980,1.1000,-5.0000,0.0000,19.0980,1.1000,-5.0000,0.0000,19.0980,1.1000,-5.0000,0.0000,3.1416},
				{0.0200,11.7520,-11.4000,19.1180,1.0000,-5.0000,0.0000,19.1180,1.0000,-5.0000,0.0000,19.1180,1.0000,-5.0000,0.0000,3.1416},
				{0.0200,11.7340,-11.4000,19.1360,0.9000,-5.0000,0.0000,19.1360,0.9000,-5.0000,0.0000,19.1360,0.9000,-5.0000,0.0000,3.1416},
				{0.0200,11.7180,-11.4000,19.1520,0.8000,-5.0000,-0.0000,19.1520,0.8000,-5.0000,0.0000,19.1520,0.8000,-5.0000,-0.0000,3.1416},
				{0.0200,11.7040,-11.4000,19.1660,0.7000,-5.0000,0.0000,19.1660,0.7000,-5.0000,0.0000,19.1660,0.7000,-5.0000,0.0000,3.1416},
				{0.0200,11.6920,-11.4000,19.1780,0.6000,-5.0000,0.0000,19.1780,0.6000,-5.0000,0.0000,19.1780,0.6000,-5.0000,0.0000,3.1416},
				{0.0200,11.6820,-11.4000,19.1880,0.5000,-5.0000,0.0000,19.1880,0.5000,-5.0000,0.0000,19.1880,0.5000,-5.0000,0.0000,3.1416},
				{0.0200,11.6740,-11.4000,19.1960,0.4000,-5.0000,-0.0000,19.1960,0.4000,-5.0000,0.0000,19.1960,0.4000,-5.0000,-0.0000,3.1416},
				{0.0200,11.6680,-11.4000,19.2020,0.3000,-5.0000,0.0000,19.2020,0.3000,-5.0000,0.0000,19.2020,0.3000,-5.0000,0.0000,3.1416},
				{0.0200,11.6640,-11.4000,19.2060,0.2000,-5.0000,0.0000,19.2060,0.2000,-5.0000,0.0000,19.2060,0.2000,-5.0000,0.0000,3.1416},
				{0.0200,11.6620,-11.4000,19.2080,0.1000,-5.0000,-0.0000,19.2080,0.1000,-5.0000,0.0000,19.2080,0.1000,-5.0000,-0.0000,3.1416},
				{0.0200,11.6620,-11.4000,19.2080,0.0000,-5.0000,0.0000,19.2080,-0.0000,-5.0000,0.0000,19.2080,0.0000,-5.0000,0.0000,3.1416},

	    };

	@Override
	public double[][] getPath() {
	    return points;
	}
}