@echo off
echo ==========================================
echo  InvisibleFrames Builder
echo ==========================================
echo.

:: Find Java automatically
if exist "C:\Program Files\Java\jdk-21" (
    set JAVA_HOME=C:\Program Files\Java\jdk-21
    goto found_java
)

if exist "C:\Program Files\Eclipse Adoptium\jdk-21" (
    set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21
    goto found_java
)

if exist "C:\Program Files\Java\jdk-17" (
    set JAVA_HOME=C:\Program Files\Java\jdk-17
    goto found_java
)

echo [ERROR] Java not found! Please install Java 21 or 17.
echo Download: https://adoptium.net/temurin/releases/?version=21
pause
exit /b 1

:found_java
echo [OK] Java found at: %JAVA_HOME%

:: Find Maven automatically
if exist "C:\Program Files\apache-maven-3.9.12\bin\mvn.cmd" (
    set MVN_CMD=C:\Program Files\apache-maven-3.9.12\bin\mvn.cmd
    goto found_maven
)

if exist "C:\Program Files\apache-maven-3.9.6\bin\mvn.cmd" (
    set MVN_CMD=C:\Program Files\apache-maven-3.9.6\bin\mvn.cmd
    goto found_maven
)

if exist "apache-maven-3.9.12\bin\mvn.cmd" (
    set MVN_CMD=apache-maven-3.9.12\bin\mvn.cmd
    goto found_maven
)

echo [ERROR] Maven not found! Please install Maven or place it in project folder.
echo Download: https://maven.apache.org/download.cgi
pause
exit /b 1

:found_maven
echo [OK] Maven found at: %MVN_CMD%
echo.

:: Build
echo [INFO] Building plugin...
echo ==========================================
"%MVN_CMD%" clean package

if %ERRORLEVEL% neq 0 (
    echo.
    echo [ERROR] Build failed!
    pause
    exit /b 1
)

echo.
echo ==========================================
echo [SUCCESS] Build completed!
echo ==========================================
echo.
echo JAR file location: target\InvisibleFrames-2.0.0.jar
echo.
echo Copy this file to your server\plugins folder
echo.
pause
