package ex04;

interface Resource {
	void use(Object key, Object... args);
	void release();
}