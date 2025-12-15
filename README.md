# 🐘 Database – Postgres + pgAdmin (Docker)

This project uses **PostgreSQL 16** with **pgAdmin 4**, fully dockerized, to simplify the local development environment setup for all team members.

The goal is that **anyone can start the database locally with a single command**, without manual configuration.

---

## 📁 Folder Structure

```
Torneo/
├── db/
│   ├── init/
│   │   └── init.sql          # Initial database script (DDL / seed data)
│   ├── pgadmin/
│   │   └── servers.json      # Automatic pgAdmin server configuration
│   └── docker-compose.yml   # Postgres + pgAdmin orchestration
├── src/
├── upload-dir/
├── pom.xml
└── README.md
```

---

## 🧩 Services Used

### PostgreSQL

* **Image**: `postgres:16`
* **Database**: `campus_games`
* **User**: `campus_admin`
* **Password**: `CampusAdmin2025!`
* **External Port**: `5433`

### pgAdmin

* **Image**: `dpage/pgadmin4`
* **URL**: [http://localhost:5050](http://localhost:5050)
* **Email**: `admin@campus.games`
* **Password**: `CampusPgAdmin2025!`

---

## ▶️ How to start the database

### 1️⃣ Prerequisites

* Docker
* Docker Compose

Check installation:

```bash
docker --version
docker compose version
```

---

### 2️⃣ Start the containers

From the project root (where `docker-compose.yml` is located):

```bash
docker compose up -d
```

On the **first execution**, Docker will:

* Create the `campus_games` database
* Create the `campus_admin` user
* Apply the database password
* Automatically execute `db/init/init.sql`

---

### 3️⃣ Access pgAdmin

Open in the browser:

👉 [http://localhost:5050](http://localhost:5050)

Login credentials:

* **Email**: `admin@campus.games`
* **Password**: `CampusPgAdmin2025!`

---

## 🔐 pgAdmin Master Password (important)

On the **first access**, pgAdmin will ask you to create a **Master Password**.

⚠️ **This is NOT the database password.**

* It can be any password
* It is used only to protect saved credentials inside pgAdmin

Example:

```
pgadmin123
```

---

## 🖥️ Database connection in pgAdmin

The server is **preconfigured automatically** via `servers.json`.

If pgAdmin asks for the database password, use:

```
CampusAdmin2025!
```

Check **Save Password**.

---

## 🔁 Recreating the database from scratch (full reset)

⚠️ Important: Postgres **does not reapply environment variables or `init.sql`** if the volume already exists.

To recreate everything from scratch:

```bash
docker compose down -v
docker compose up -d
```

This will:

* Delete existing database data
* Recreate users and password
* Run `init.sql` again

---

## 🔌 External connection (DBeaver, IntelliJ, etc.)

To connect from outside Docker:

* **Host**: `localhost`
* **Port**: `5433`
* **Database**: `campus_games`
* **User**: `campus_admin`
* **Password**: `CampusAdmin2025!`

---

## 🧠 Important notes

* `init.sql` runs **only on the first volume creation**
* Changes to `POSTGRES_USER` or `POSTGRES_PASSWORD` require `docker compose down -v`
* pgAdmin connects to Postgres using the Docker service name (`postgres`)

---

## ✅ Done!

With this setup, the entire team can run and access the database locally in a standardized and reliable way.

If you face any issues:

1. Stop the containers
2. Run `docker compose down -v`
3. Start them again

🚀
