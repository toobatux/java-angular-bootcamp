# Git and Maven Hygiene

Module 0 Ex 4 — fill every TODO.

## Step 1 — Git identity

```bash
git config --global user.name "Tom Krusinski"
git config --global user.email "toobatux@gmail.com"
```

## Step 2 — Personal repo

```bash
git clone https://github.com/ExgnosisClasses/2617-JavaAngular-Sept14/
rm -rf .git/
git init
git add .
git branch -M main
git commit -m "Initial"
git remote add origin https://github.com/toobatux/java-angular-bootcamp.git
git push -u origin main
```

## Step 3 — Maven

```bash
brew install maven
mvn -version
```

## Step 4 — Secrets

```text
1. Never commit credentials, API keys, database passwords, secret config files (.env), etc.
2. Always add sensitive files to .gitignore
3. Use environment variables for local development
```
