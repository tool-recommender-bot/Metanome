package de.uni_potsdam.hpi.metanome.algorithm_integration.algorithm_types;

import de.uni_potsdam.hpi.metanome.algorithm_integration.Algorithm;
import de.uni_potsdam.hpi.metanome.algorithm_integration.AlgorithmConfigurationException;

/**
 * An {@link Algorithm} that takes boolean configuration values.
 * 
 * @author Jakob Zwiener
 */
public interface BooleanParameterAlgorithm extends Algorithm {

	/**
	 * Sets a boolean configuration value on the algorithm.
	 * 
	 * @param identifier
	 * @param values
	 */
	void setConfigurationValue(String identifier, boolean... values) throws AlgorithmConfigurationException;
	
}
