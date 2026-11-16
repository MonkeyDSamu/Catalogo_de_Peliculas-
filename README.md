# Catalogo_de_Peliculas-
Se desarrollará un programa llamado Catálogo de Películas en Java que permitirá registrar, consultar, buscar, modificar y eliminar películas desde la consola mediante un menú interactivo, aplicando las operaciones CRUD y conceptos básicos de programación.

## Archivos del proyecto

| Archivo | Descripción |
|---|---|
| `Main.java` | Punto de entrada: menú, lectura de datos con `Scanner` y validaciones. |
| `Catalogo.java` | Guarda las películas en arrays y ofrece agregar, mostrar y buscar. |

## Funcionalidades actuales

1. **Agregar película**: título, director, género, año y calificación (0 a 10).
2. **Mostrar películas**: lista todas las registradas o avisa si no hay ninguna.
3. **Buscar película**: por título (no distingue mayúsculas de minúsculas).

## Cómo compilar y ejecutar

Requiere JDK 17 o superior.

```bash
javac *.java
java Main
```

## Flujo de trabajo con Git (GitFlow)

Se trabaja con un modelo GitFlow simplificado, con estas ramas:

| Rama | Para qué sirve |
|---|---|
| `main` | Versión estable del proyecto. |
| `develop` | Rama de integración donde se juntan las funcionalidades terminadas. |
| `feature/*` | Una rama por cada funcionalidad nueva (por ejemplo `feature/agregar-pelicula`). |

**Regla de oro:** nunca se hace `push` directo a `main` ni a `develop`. Todo cambio llega mediante un **Pull Request**.

### Paso a paso para subir un cambio

1. Ubicarse en `develop` y actualizarla:
   ```bash
   git checkout develop
   git pull origin develop
   ```
2. Crear la rama de la funcionalidad a partir de `develop`:
   ```bash
   git checkout -b feature/nombre-de-la-funcionalidad
   ```
3. Hacer los cambios en el código y revisar qué se modificó:
   ```bash
   git status
   ```
4. Agregar los archivos y crear el commit:
   ```bash
   git add .
   git commit -m "feat: descripción corta del cambio"
   ```
5. Subir la rama al repositorio remoto:
   ```bash
   git push -u origin feature/nombre-de-la-funcionalidad
   ```
6. En GitHub, abrir un **Pull Request** con base `develop` y comparar con la rama `feature/...`. Describir qué se hizo.
7. Luego de creado el **Pull Request** haces merge del **Pull Request** y los cambios estarán en la rama develop.
8. Limpiar y actualizar el repositorio local:
   ```bash
   git checkout develop
   git pull origin develop
   git branch -d feature/nombre-de-la-funcionalidad
   ```
9. Cuando `develop` esté estable y probada, abrir un **Pull Request de `develop` hacia `main`** y hacer el merge tras su aprobación.
