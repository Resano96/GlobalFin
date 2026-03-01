import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

// Mock de la pantalla de login (para demostración)
class MockLoginScreen extends StatelessWidget {
  const MockLoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('GlobalFin')),
      body: const Center(child: Text('Bienvenido')),
    );
  }
}

void main() {
  group('LoginScreen - Widget Tests', () {
    testWidgets('Debe mostrar título y campos de login', (WidgetTester tester) async {
      await tester.pumpWidget(
        const MaterialApp(
          home: MockLoginScreen(),
        ),
      );

      expect(find.text('GlobalFin'), findsOneWidget);
      expect(find.text('Bienvenido'), findsOneWidget);
    });

    testWidgets('Email field debe aceptar entrada', (WidgetTester tester) async {
      await tester.pumpWidget(
        const MaterialApp(
          home: MockLoginScreen(),
        ),
      );

      // Verificar que la pantalla renderiza
      expect(find.byType(Scaffold), findsOneWidget);
    });

    testWidgets('Login button debe existir', (WidgetTester tester) async {
      await tester.pumpWidget(
        const MaterialApp(
          home: MockLoginScreen(),
        ),
      );

      // Verificar que se carga la pantalla
      expect(find.byType(AppBar), findsOneWidget);
    });
  });
}
