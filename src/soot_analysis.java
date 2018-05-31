import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.options.Options;


public class soot_analysis {
		public static void main(String[] args){
			Options.v().parse(args);
			SootClass c = Scene.v().forceResolve("AbumController", SootClass.BODIES);
			Scene.v().loadNecessaryClasses();	
			c.setApplicationClass();
			SootMethod method = c.getMethodByName("hadleCommad");
			Body body = method.retrieveActiveBody();
			System.out.println("Method Body: "+body);
		}
}
