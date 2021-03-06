package jadx.tests.internal;

import jadx.api.InternalJadxTest;
import jadx.core.dex.nodes.ClassNode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class TestStaticMethod extends InternalJadxTest {

	public static class TestCls {
		static {
			f();
		}

		private static void f() {
		}
	}

	@Test
	public void test() {
		ClassNode cls = getClassNode(TestCls.class);
		String code = cls.getCode().toString();

		assertThat(code, containsString("static {"));
		assertThat(code, containsString("private static void f() {"));
	}
}
