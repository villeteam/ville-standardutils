package edu.vserver.exercises.math.essentials.generator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;

public abstract class MathGeneratorXML {
	
	private static final String[][] VERSION = new String[][]{
		/*0 or no version*/
		{"numberOfTerms","allowedOperators","termRange","manualCalculations","answerRange",
			"allowParenthesis","boundingType","separateRanges"},
		/*1*/
		{"MG_numberOfTerms","MG_allowedOperators","MG_termRange","MG_manualCalculations",
				"MG_answerRange","MG_allowParenthesis","MG_boundingType","MG_separateRanges"},
		/*2*/
		{"MG_numberOfTerms","MG_allowedOperators","MG_termRange","MG_manualCalculations",
				"MG_answerRange","MG_allowParenthesis","MG_boundingType","MG_separateRanges",
				"MG_forceParenthesis"},
		/*3*/
		{"MG_numberOfTerms","MG_allowedOperators","MG_termRange","MG_manualCalculations",
				"MG_answerRange","MG_allowParenthesis","MG_boundingType","MG_separateRanges",
				"MG_forceParenthesis","MG_allowNegativesWhenBoundedByTerms"}
		};
	private static final int currentVersion = 3;
	
	public static void saveDataToDocument(Document document, MathGeneratorExerciseData data){
		Node root = document.getDocumentElement();
		if(root == null){
			root = document.appendChild(document.createElement("Math_Generator_Data"));
		}
		root = root.appendChild(document.createElement("Math_Generator"));
		
		Node currentNode;
		
		currentNode = root.appendChild(document.createElement("MG_VersionID"));
		currentNode.setTextContent(currentVersion+"");
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][0]));
		currentNode.setTextContent(Integer.toString(data.getNumberOfTerms()));
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][1]));
		for(Operator o : data.getOperators()){
			currentNode.appendChild(document.createElement(o.toString()));
		}
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][2]));
		for(int i=0; i<data.getNumberOfTerms(); i++){
			Node termNode = currentNode.appendChild(document.createElement("term_"+i));
			Node n = termNode.appendChild(document.createElement("min")); 
			n.setTextContent(data.getMinValueForTerm(i).doubleValue()+"");
			
			n = termNode.appendChild(document.createElement("max")); 
			n.setTextContent(data.getMaxValueForTerm(i).doubleValue()+"");

			n = termNode.appendChild(document.createElement("allowedDecimals")); 
			n.setTextContent(data.getNumberOfDecimalsInTerm(i)+"");
			
			n = termNode.appendChild(document.createElement("forcedMultiplier")); 
			n.setTextContent(data.getForcedMultiplier(i)+"");
						
		}
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][3]));
//		System.out.println("manualCalcSize: "+data.getManualCalculations().size());
		for(int i=0; i<data.getManualCalculations().size(); i++){
			Node calc = currentNode.appendChild(document.createElement("manCalc"+i));
			calc.setTextContent(data.getManualCalculations().get(i).toString());
		}
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][4]));
		{
			Node termNode = currentNode.appendChild(document.createElement("answer"));
			Node n = termNode.appendChild(document.createElement("min")); 
			n.setTextContent(data.getMinValueForSolution().doubleValue()+"");
			
			n = termNode.appendChild(document.createElement("max")); 
			n.setTextContent(data.getMaxValueForSolution().doubleValue()+"");
	
			n = termNode.appendChild(document.createElement("allowedDecimals")); 
			n.setTextContent(data.getNumberOfDecimalsInSolution()+"");
		}
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][5]));
		currentNode.setTextContent(data.getAllowParenthesis()+"");
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][6]));
		currentNode.setTextContent(data.getBoundingType().toString());
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][7]));
		currentNode.setTextContent(data.getSeparateTermRangesFlag()+"");
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][8]));
		currentNode.setTextContent(data.getForceParenthesis()+"");
		
		currentNode = root.appendChild(document.createElement(VERSION[currentVersion][9]));
		currentNode.setTextContent(data.getAllowNegativesWhenBoundedByTerms()+"");
	}
	
	/**
	 * Reads all MathGenerator data from the given document.
	 * @param document The document to read Math Generator data from
	 * @return An array containing all Math Generator Exercise Data found in the given document.
	 */
	public static MathGeneratorExerciseData[] readDataFromDocument(Document document){
		Node root = document.getElementsByTagName("Math_Generator").item(0);
		if(root == null){
			return new MathGeneratorExerciseData[]{new MathGeneratorExerciseData(2)};
		}
		
		Node versionNode = document.getElementsByTagName("MG_VersionID").item(0);
		int version =0;
		if(versionNode != null)
			version = Integer.parseInt(versionNode.getTextContent());
		
		String[] nodeNames = VERSION[version];
		
		switch(version){
		case 0:
			return parseVersion0(document, nodeNames);
		case 1:
			return parseVersion1(document, nodeNames);
		case 2:
			return parseVersion2(document, nodeNames);
		case 3:
			return parseVersion3(document, nodeNames);
		}
		
		return new MathGeneratorExerciseData[]{new MathGeneratorExerciseData(2)};
	}
	
	private static MathGeneratorExerciseData[] parseVersion3(Document document, String[] nodeNames) {
		NodeList generatorDatas = document.getElementsByTagName("Math_Generator");
		MathGeneratorExerciseData[] generatorData = new MathGeneratorExerciseData[generatorDatas.getLength()];
		
		for(int generatorIndex = 0 ; generatorIndex< generatorDatas.getLength(); generatorIndex++){
			Node currentNode;
			
			currentNode = document.getElementsByTagName(nodeNames[0]).item(generatorIndex);		
			MathGeneratorExerciseData data = new MathGeneratorExerciseData();
			
			data.setNumberOfTerms(Integer.parseInt(currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[1]).item(generatorIndex);
			currentNode = currentNode.getFirstChild();
			while(currentNode != null){
				switch(currentNode.getNodeName()){
				case "SUM":
					data.setAdditionAllowed(true);
					break;
				case "SUBTRACT":
					data.setSubtractionAllowed(true);
					break;
				case "MULTIPLICATION":
					data.setMultiplicationAllowed(true);
					break;
				case "DIVISION":
					data.setDivisionAllowed(true);
					break;
				}
				currentNode = currentNode.getNextSibling();
			}
			
			NodeList currentNodes = document.getElementsByTagName(nodeNames[2]);
			//for(int i=0; i<currentNodes.getLength(); i++){
				for(int j=0; j<currentNodes.item(generatorIndex).getChildNodes().getLength(); j++){
					NodeList range = currentNodes.item(generatorIndex).getChildNodes().item(j).getChildNodes();
					data.setMinValueForTerm(Double.parseDouble(range.item(0).getTextContent()), j);
					data.setMaxValueForTerm(Double.parseDouble(range.item(1).getTextContent()), j);
					data.setNumberOfDecimalsInTerm(j, Integer.parseInt(range.item(2).getTextContent()));
					data.setForcedMultiplier(j, Double.parseDouble(range.item(3).getTextContent()));
					data.setTermBound(true, j);
				}	
			//}
			
			currentNodes = document.getElementsByTagName(nodeNames[3]).item(generatorIndex).getChildNodes();
			StringBuilder b = new StringBuilder();
			for(int i=0; i<currentNodes.getLength(); i++){
				b.append(currentNodes.item(i).getTextContent());
				if(i != currentNodes.getLength()-1)
					b.append("\n");
			}
			if(!b.toString().isEmpty())
				data.setManualCalculations(b.toString());
					
//			ArrayList<ManualCalculation> l =data.getManualCalculations().getCalculations();
//			for(ManualCalculation m : l)
//				System.out.println(m.getExpression()+m.getAnswer());
			
			currentNodes = document.getElementsByTagName(nodeNames[4]);
			for(int i=0; i<currentNodes.getLength(); i++){
			if(currentNodes.item(generatorIndex).getParentNode() == generatorDatas.item(generatorIndex))
				for(int j=0; j<currentNodes.item(generatorIndex).getChildNodes().getLength(); j++){
					NodeList range = currentNodes.item(generatorIndex).getChildNodes().item(j).getChildNodes();
					data.setMinValueForSolution(Double.parseDouble(range.item(0).getTextContent()));
					data.setMaxValueForSolution(Double.parseDouble(range.item(1).getTextContent()));
					data.setNumberOfDecimalsInSolution(Integer.parseInt(range.item(2).getTextContent()));
					data.setSolutionBound(true);
				}	
			}
			
			currentNode = document.getElementsByTagName(nodeNames[5]).item(generatorIndex);
			data.setAllowParenthesis(Boolean.parseBoolean(currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[6]).item(generatorIndex);
			data.setBoundingType(Enum.valueOf(BoundingType.class, currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[7]).item(generatorIndex);
			data.setSeparateTermsFlag(Boolean.parseBoolean(currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[8]).item(generatorIndex);
			data.setForceParenthesis(Boolean.parseBoolean(currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[9]).item(generatorIndex);
			data.setAllowNegativesWhenBoundedByTerms(Boolean.parseBoolean(currentNode.getTextContent()));
			generatorData[generatorIndex] = data;
		}
		return generatorData;
	}

	private static MathGeneratorExerciseData[] parseVersion2(Document document, String[] nodeNames){
		{

			NodeList generatorDatas = document.getElementsByTagName("Math_Generator");
			MathGeneratorExerciseData[] generatorData = new MathGeneratorExerciseData[generatorDatas.getLength()];
			
			for(int generatorIndex = 0 ; generatorIndex< generatorDatas.getLength(); generatorIndex++){
				Node currentNode;
				
				currentNode = document.getElementsByTagName(nodeNames[0]).item(generatorIndex);		
				MathGeneratorExerciseData data = new MathGeneratorExerciseData();
				
				data.setNumberOfTerms(Integer.parseInt(currentNode.getTextContent()));
				
				currentNode = document.getElementsByTagName(nodeNames[1]).item(generatorIndex);
				currentNode = currentNode.getFirstChild();
				while(currentNode != null){
					switch(currentNode.getNodeName()){
					case "SUM":
						data.setAdditionAllowed(true);
						break;
					case "SUBTRACT":
						data.setSubtractionAllowed(true);
						break;
					case "MULTIPLICATION":
						data.setMultiplicationAllowed(true);
						break;
					case "DIVISION":
						data.setDivisionAllowed(true);
						break;
					}
					currentNode = currentNode.getNextSibling();
				}
				
				NodeList currentNodes = document.getElementsByTagName(nodeNames[2]);
				//for(int i=0; i<currentNodes.getLength(); i++){
					for(int j=0; j<currentNodes.item(generatorIndex).getChildNodes().getLength(); j++){
						NodeList range = currentNodes.item(generatorIndex).getChildNodes().item(j).getChildNodes();
						data.setMinValueForTerm(Double.parseDouble(range.item(0).getTextContent()), j);
						data.setMaxValueForTerm(Double.parseDouble(range.item(1).getTextContent()), j);
						data.setNumberOfDecimalsInTerm(j, Integer.parseInt(range.item(2).getTextContent()));
						data.setForcedMultiplier(j, Double.parseDouble(range.item(3).getTextContent()));
						data.setTermBound(true, j);
					}	
				//}
				
				currentNodes = document.getElementsByTagName(nodeNames[3]).item(generatorIndex).getChildNodes();
				StringBuilder b = new StringBuilder();
				for(int i=0; i<currentNodes.getLength(); i++){
					b.append(currentNodes.item(i).getTextContent());
					if(i != currentNodes.getLength()-1)
						b.append("\n");
				}
				if(!b.toString().isEmpty())
					data.setManualCalculations(b.toString());
						
//				ArrayList<ManualCalculation> l =data.getManualCalculations().getCalculations();
//				for(ManualCalculation m : l)
//					System.out.println(m.getExpression()+m.getAnswer());
				
				currentNodes = document.getElementsByTagName(nodeNames[4]);
				for(int i=0; i<currentNodes.getLength(); i++){
				if(currentNodes.item(generatorIndex).getParentNode() == generatorDatas.item(generatorIndex))
					for(int j=0; j<currentNodes.item(generatorIndex).getChildNodes().getLength(); j++){
						NodeList range = currentNodes.item(generatorIndex).getChildNodes().item(j).getChildNodes();
						data.setMinValueForSolution(Double.parseDouble(range.item(0).getTextContent()));
						data.setMaxValueForSolution(Double.parseDouble(range.item(1).getTextContent()));
						data.setNumberOfDecimalsInSolution(Integer.parseInt(range.item(2).getTextContent()));
						data.setSolutionBound(true);
					}	
				}
				
				currentNode = document.getElementsByTagName(nodeNames[5]).item(generatorIndex);
				data.setAllowParenthesis(Boolean.parseBoolean(currentNode.getTextContent()));
				
				currentNode = document.getElementsByTagName(nodeNames[6]).item(generatorIndex);
				data.setBoundingType(Enum.valueOf(BoundingType.class, currentNode.getTextContent()));
				
				currentNode = document.getElementsByTagName(nodeNames[7]).item(generatorIndex);
				data.setSeparateTermsFlag(Boolean.parseBoolean(currentNode.getTextContent()));
				
				currentNode = document.getElementsByTagName(nodeNames[8]).item(generatorIndex);
				data.setForceParenthesis(Boolean.parseBoolean(currentNode.getTextContent()));
				
				generatorData[generatorIndex] = data;
			}
			return generatorData;
		}
	}
	
	private static MathGeneratorExerciseData[] parseVersion1(Document document, String[] nodeNames){
		return parseVersion0(document, nodeNames);
	}
	
	private static MathGeneratorExerciseData[] parseVersion0(Document document, String[] nodeNames){

		NodeList generatorDatas = document.getElementsByTagName("Math_Generator");
		MathGeneratorExerciseData[] generatorData = new MathGeneratorExerciseData[generatorDatas.getLength()];
		
		for(int generatorIndex = 0 ; generatorIndex< generatorDatas.getLength(); generatorIndex++){
			Node currentNode;
			
			currentNode = document.getElementsByTagName(nodeNames[0]).item(generatorIndex);		
			MathGeneratorExerciseData data = new MathGeneratorExerciseData(Integer.parseInt(currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[1]).item(generatorIndex);
			currentNode = currentNode.getFirstChild();
			while(currentNode != null){
				switch(currentNode.getNodeName()){
				case "SUM":
					data.setAdditionAllowed(true);
					break;
				case "SUBTRACT":
					data.setSubtractionAllowed(true);
					break;
				case "MULTIPLICATION":
					data.setMultiplicationAllowed(true);
					break;
				case "DIVISION":
					data.setDivisionAllowed(true);
					break;
				}
				currentNode = currentNode.getNextSibling();
			}
			
			NodeList currentNodes = document.getElementsByTagName(nodeNames[2]);
			//for(int i=0; i<currentNodes.getLength(); i++){
				for(int j=0; j<currentNodes.item(generatorIndex).getChildNodes().getLength(); j++){
					NodeList range = currentNodes.item(generatorIndex).getChildNodes().item(j).getChildNodes();
					data.setMinValueForTerm(Double.parseDouble(range.item(0).getTextContent()), j);
					data.setMaxValueForTerm(Double.parseDouble(range.item(1).getTextContent()), j);
					data.setNumberOfDecimalsInTerm(j, Integer.parseInt(range.item(2).getTextContent()));
					data.setForcedMultiplier(j, Double.parseDouble(range.item(3).getTextContent()));
					data.setTermBound(true, j);
				}	
			//}
			
			currentNodes = document.getElementsByTagName(nodeNames[3]).item(generatorIndex).getChildNodes();
			StringBuilder b = new StringBuilder();
			for(int i=0; i<currentNodes.getLength(); i++){
				b.append(currentNodes.item(i).getTextContent());
				if(i != currentNodes.getLength()-1)
					b.append("\n");
			}
			if(!b.toString().isEmpty())
				data.setManualCalculations(b.toString());
					
//			ArrayList<ManualCalculation> l =data.getManualCalculations().getCalculations();
//			for(ManualCalculation m : l)
//				System.out.println(m.getExpression()+m.getAnswer());
			
			currentNodes = document.getElementsByTagName(nodeNames[4]);
			for(int i=0; i<currentNodes.getLength(); i++){
			if(currentNodes.item(generatorIndex).getParentNode() == generatorDatas.item(generatorIndex))
				for(int j=0; j<currentNodes.item(generatorIndex).getChildNodes().getLength(); j++){
					NodeList range = currentNodes.item(generatorIndex).getChildNodes().item(j).getChildNodes();
					data.setMinValueForSolution(Double.parseDouble(range.item(0).getTextContent()));
					data.setMaxValueForSolution(Double.parseDouble(range.item(1).getTextContent()));
					data.setNumberOfDecimalsInSolution(Integer.parseInt(range.item(2).getTextContent()));
					data.setSolutionBound(true);
				}	
			}
			
			currentNode = document.getElementsByTagName(nodeNames[5]).item(generatorIndex);
			data.setAllowParenthesis(Boolean.parseBoolean(currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[6]).item(generatorIndex);
			data.setBoundingType(Enum.valueOf(BoundingType.class, currentNode.getTextContent()));
			
			currentNode = document.getElementsByTagName(nodeNames[7]).item(generatorIndex);
			data.setSeparateTermsFlag(Boolean.parseBoolean(currentNode.getTextContent()));
			
			generatorData[generatorIndex] = data;
		}
		return generatorData;
	}
}
