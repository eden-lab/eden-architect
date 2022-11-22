package org.ylzl.eden.cola.statemachine;

/**
 * 流转类型
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public enum TransitionType {

	LOCAL,
	INTERNAL, // 内部流转，同一个状态之间的流转
	EXTERNAL // 外部流转，两个不同状态之间的流转
}
