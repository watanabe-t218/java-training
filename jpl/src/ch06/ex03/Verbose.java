/**
 * 
 */
package ex03;

/**
 * @author Watari-Home
 *
 */
public interface Verbose {
	enum Verbosity {
		SILENT, 
		TERSE, 
		NORMAL, 
		VERBOSE
	}

	void setVerbosity(Verbosity level);
	int getVerbosity();
}
