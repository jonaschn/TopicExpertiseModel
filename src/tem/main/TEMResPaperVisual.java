package tem.main;

import tem.conf.PathConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TEMResPaperVisual {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws IOException, Exception {
		// String modelFile = PathConfig.modelResPath + "ServerTEMRes/Model_E10_T15.model";
		String modelFile = PathConfig.modelResPath + "USER80/E10_T15.model";

		//Get TEM model result
		TEMModel model = new TEMModel();
		// load model
		System.out.println("reading a class from : " + modelFile);
		FileInputStream fis = new FileInputStream(modelFile);
		ObjectInputStream ois = new ObjectInputStream(fis);
		model = (TEMModel) ois.readObject();
		ois.close();

		System.out.println("Number of topics: " + model.K);
		System.out.println("Number of expertise levels: " + model.ENum);
		System.out.println("mu for each expertise level:");
		for(int e = 0; e < model.ENum; e++){
			System.out.println(model.fgmm.p_mu[e][0]);
		}
		System.out.println("lambda for each expertise level:");
		for(int e = 0; e < model.ENum; e++){
			System.out.println(model.fgmm.p_lambda[e][0]);
		}


	}

}
