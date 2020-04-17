package ex05;

interface Resource {
	void use(Object key, Object... args);
	void release();
}