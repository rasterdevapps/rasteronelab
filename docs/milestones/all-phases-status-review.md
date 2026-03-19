# RasterOneLab LIS — All Phases Status Review

> **Review Date:** 2026-03-19
> **Scope:** All 8 development phases (LIS-001 through LIS-135)
> **Reviewed By:** Automated codebase analysis

---

## Executive Summary

| Phase | Issues | Status | Progress | Key Blocker |
|-------|--------|--------|----------|-------------|
| Phase 1 — Foundation | 15 | ✅ Complete | **100%** | — |
| Phase 2 — Administration Module | 18 | 🟡 In Progress | **~90%** | 4 missing backend entities; test coverage 29% |
| Phase 3 — Patient & Ordering | 21 | 🟡 Scaffolded | **~30%** | Order state machine; UHID generation; panel expansion |
| Phase 4 — Sample Management | 14 | ⬜ Not Started | **0%** | Blocked by Phase 3 state machine |
| Phase 5 — Result Entry & Validation | 20 | ⬜ Not Started | **0%** | Blocked by Phase 4 |
| Phase 6 — Instrument Interface | 12 | ⬜ Not Started | **0%** | Can overlap with Phase 5 |
| Phase 7 — Reports, QC & Notifications | 17 | ⬜ Not Started | **0%** | Blocked by Phase 5 |
| Phase 8 — Portals, Analytics & Launch | 18 | ⬜ Not Started | **0%** | Blocked by Phase 7 |
| **Total** | **135** | | | |

**Overall project completion: ~27%** (Phases 1–3 weighted, all others 0%)

---

## Phase 1 — Foundation ✅ COMPLETE (100%)

**Timeline:** Months 1–2 | **Issues:** 15 (LIS-001 to LIS-015)

### Implementation Summary

| Layer | Component | Status |
|-------|-----------|--------|
| Core | BaseEntity, ApiResponse, PagedResponse, exceptions | ✅ |
| Core | BranchContextHolder, BranchInterceptor | ✅ |
| Core | BranchAwareRepository | ✅ |
| Auth | Keycloak realm (10 roles, JWT claims, test users) | ✅ |
| Auth | Spring Security OAuth2 Resource Server | ✅ |
| Gateway | Spring Cloud Gateway routing + JWT validation + rate limiting | ✅ |
| Frontend | Angular 19 scaffold, auth flow, BranchInterceptor, layout | ✅ |
| Infrastructure | Docker Compose (Postgres, Redis, RabbitMQ, Keycloak, ES, MinIO) | ✅ |
| Infrastructure | Jenkins CI/CD pipeline (multi-branch) | ✅ |
| Infrastructure | Dockerfiles for backend and frontend | ✅ |
| Database | Flyway framework, core tables | ✅ |
| Tests | lis-core (8 tests), lis-auth (1 test), lis-gateway (1 test) | ✅ |

### Issue Status

| Issue | Title | Status |
|-------|-------|--------|
| LIS-001 | BaseEntity with UUID v7, audit fields, soft delete | ✅ Done |
| LIS-002 | ApiResponse and PagedResponse | ✅ Done |
| LIS-003 | Global exception handler and custom exceptions | ✅ Done |
| LIS-004 | BranchContextHolder and BranchInterceptor | ✅ Done |
| LIS-005 | BranchAwareRepository base interface | ✅ Done |
| LIS-006 | Keycloak realm with roles and custom claims | ✅ Done |
| LIS-007 | Spring Security OAuth2 Resource Server | ✅ Done |
| LIS-008 | Spring Cloud Gateway routing and JWT validation | ✅ Done |
| LIS-009 | Angular 19 application with authentication flow | ✅ Done |
| LIS-010 | Angular BranchInterceptor and BranchService | ✅ Done |
| LIS-011 | Shared Angular layout and navigation components | ✅ Done |
| LIS-012 | Docker Compose for all services | ✅ Done |
| LIS-013 | CI/CD pipeline with Jenkins | ✅ Done |
| LIS-014 | Dockerfiles for backend and frontend | ✅ Done |
| LIS-015 | Flyway migration framework and core tables | ✅ Done |

> **Phase 1 verdict: ✅ 100% complete. No action required.**

---

## Phase 2 — Administration Module 🟡 IN PROGRESS (~90%)

**Timeline:** Months 2–4 | **Issues:** 18 (LIS-016 to LIS-033)

### Implementation Metrics

| Layer | Implemented | Notes |
|-------|-------------|-------|
| Backend Java files | 154 | `lis-admin` module |
| JPA Entities | 30 | All master data entities |
| Repositories | 28 | Full persistence layer |
| Services | 26 | CRUD + business logic |
| Controllers | 26 | REST endpoints with `@PreAuthorize` |
| DTOs (Request/Response) | 52 | MapStruct-mapped |
| MapStruct Mappers | 26 | Entity ↔ DTO |
| Flyway Migrations | 26 | Forward + rollback scripts |
| Service Unit Tests | 6 of 21 | **29% coverage — target is 80%** |
| Frontend Components | 42 | List + form pairs for 21 entities |
| Frontend Tests | 0 | No `.spec.ts` files |

### Issue Status

| Issue | Title | Status | Gap |
|-------|-------|--------|-----|
| LIS-016 | Organization CRUD API | ✅ Complete | No unit tests |
| LIS-017 | Branch Management CRUD API | ✅ Complete | No unit tests |
| LIS-018 | Department Management CRUD API | ✅ Complete | No unit tests; seed data ✅ (PR #16 — R__001) |
| LIS-019 | Test Master CRUD API | ✅ Complete | No unit tests |
| LIS-020 | Parameter Master CRUD API | ✅ Complete | No unit tests |
| LIS-021 | Reference Range Config API | ✅ Complete | No unit tests |
| LIS-022 | Test Panel Management API | ✅ Complete | No unit tests |
| LIS-023 | Pricing Catalog API | ✅ Complete | Tests exist (PriceCatalogServiceTest) |
| LIS-024 | Doctor Management API | ✅ Complete | Tests exist (DoctorServiceTest) |
| LIS-025 | User Management API | ✅ Complete | Tests exist (AppUserServiceTest) |
| LIS-026 | Number Series Config API | ✅ Complete | Tests exist (NumberSeriesServiceTest) |
| LIS-027 | TAT Configuration API | ✅ Complete | No unit tests |
| LIS-028 | Working Hours & Holiday Config API | ✅ Complete | No unit tests |
| LIS-029 | Critical Value Config API | ✅ Complete | Tests exist (CriticalValueConfigServiceTest) |
| LIS-030 | Delta Check & Auto-validation Config API | ✅ Complete | No unit tests |
| LIS-031 | Antibiotic & Microorganism Masters API | ✅ Complete | Tests exist (AntibioticServiceTest) |
| LIS-032 | Configuration Screens (Notification/Report Templates) | ⚠️ Partial | Backend for NotificationTemplate, ReportTemplate, DiscountScheme, InsuranceTariff **missing** |
| LIS-033 | Role & Permission Management API | ✅ Complete | Full Java stack (entity, repo, service, controller, DTOs, mapper); DB schema ✅ (V20260318_0016); seed data ✅ (PR #16 — R__008) |

### 🔴 Critical Gaps in Phase 2

1. **4 missing backend entities** — frontend screens exist, APIs are absent:
   - `NotificationTemplate` (TASK-P2-01)
   - `ReportTemplate` (TASK-P2-02)
   - `DiscountScheme` (TASK-P2-03)
   - `InsuranceTariff` (TASK-P2-04)

   > **✅ Resolved (PR #16):** `Role` / `Permission` — DB schema (V20260318_0016) and seed data (R__008) added; full Java CRUD stack already existed.
   > **✅ Resolved (PR #16):** Seed data — 12 repeatable migrations (R__001–R__012) added: 11 departments, 15 sample types, 60+ antibiotics, 80+ microorganisms, CLSI breakpoints, units, roles/permissions, report templates, rejection reasons, number series, critical values.

2. **Test coverage: 29%** — only 6 of 21 services tested (target: 80%); 15 services need tests (TASK-P2-07)

3. **No frontend unit tests** — 42 components, 0 `.spec.ts` files (TASK-P2-08)

> **Phase 2 verdict: 🟡 ~90% — 3 tasks remain before closure (4 missing entities, test coverage, frontend tests). Estimated effort: 2 weeks (single developer, sequential). With 2–3 developers in parallel the calendar time reduces to ~1 week.**
> See [pending-tasks.md](pending-tasks.md) for the full task breakdown with file checklists.

---

## Phase 3 — Patient & Ordering 🟡 SCAFFOLDED (~30%)

**Timeline:** Months 4–6 | **Issues:** 21 (LIS-034 to LIS-054)

### Implementation Metrics

| Module | Entities | Repos | Services | Controllers | Tests | Migrations |
|--------|----------|-------|----------|-------------|-------|------------|
| `lis-patient` | 5 | 3 | 2 | 2 | 1 | 4 |
| `lis-order` | 5 | 2 | 1 | 1 | 1 | 2 |
| `lis-billing` | 10 | 5 | 4 | 4 | 2 | 5 |
| **Total** | **20** | **10** | **7** | **7** | **4** | **11** |

### Issue Status

| Issue | Title | Status | Notes |
|-------|-------|--------|-------|
| LIS-034 | Patient CRUD API with UHID generation | ⚠️ Partial | Entity exists; UHID sequence + pessimistic locking **not implemented** |
| LIS-035 | Duplicate patient detection and merge | ⚠️ Partial | `PatientMergeAudit` entity exists; detection algorithm **not implemented** |
| LIS-036 | Patient Visit Management | ⚠️ Partial | `PatientVisit` entity exists; auto-create on order **not wired** |
| LIS-037 | Patient Demographics & PHI Audit | ❌ Not Done | No PHI audit logging |
| LIS-038 | Patient Search (multi-criteria) | ❌ Not Done | No Elasticsearch integration |
| LIS-039 | Patient Angular screens (12 screens) | ⬜ Scaffold | HTML/SCSS absent; no tests |
| LIS-040 | Test Order API with panel expansion | ⚠️ Partial | `TestOrder` + `OrderLineItem` entities exist; panel expansion **not implemented** |
| LIS-041 | Order State Machine | ❌ Not Done | States defined in enum; transitions **not implemented** |
| LIS-042 | Barcode Generation for Orders | ❌ Not Done | Barcode utility class exists in `lis-core`; not wired to orders |
| LIS-043 | Order Search & Worklist API | ❌ Not Done | No filtering/sorting/pagination |
| LIS-044 | Order Angular screens (10 screens) | ⬜ Scaffold | HTML/SCSS absent; no tests |
| LIS-045 | Invoice Generation API | ⚠️ Partial | `Invoice` + `InvoiceLineItem` entities exist; generation logic **incomplete** |
| LIS-046 | Payment Recording API | ⚠️ Partial | `Payment` entity exists; multi-payment + splits **not done** |
| LIS-047 | Discount & Concession Application | ❌ Not Done | No discount application logic |
| LIS-048 | Insurance Billing API | ❌ Not Done | No insurance claim logic |
| LIS-049 | Receipt Generation | ❌ Not Done | No receipt PDF |
| LIS-050 | Corporate Billing Aggregation | ❌ Not Done | No corporate billing logic |
| LIS-051 | Billing Angular screens (12 screens) | ⬜ Scaffold | HTML/SCSS absent; no tests |
| LIS-052 | Credit Management API | ❌ Not Done | Not implemented |
| LIS-053 | Financial Reports API (basic) | ❌ Not Done | Not implemented |
| LIS-054 | Refund & Cancellation API | ❌ Not Done | Not implemented |

### 🔴 Critical Gaps in Phase 3

1. **Order State Machine not implemented** — orders cannot transition from DRAFT → PLACED → PAID → SAMPLE_COLLECTED → … → COMPLETED. This blocks Phase 4.
2. **UHID generation not complete** — pessimistic locking sequence is absent.
3. **Panel expansion logic absent** — tests in a panel are not split by tube type for sample management.
4. **Barcode generation not wired** — barcode utility exists but is disconnected from order creation.
5. **Frontend is scaffold only** — 34 screens have TypeScript stubs with no HTML, SCSS, or tests.

> **Phase 3 verdict: 🟡 ~30% — Core domain logic (state machine, UHID, panel expansion) not yet implemented. Estimated effort to complete: 6 weeks.**

---

## Phase 4 — Sample Management ⬜ NOT STARTED (0%)

**Timeline:** Months 6–8 | **Issues:** 14 (LIS-055 to LIS-068)

### Planned Deliverables

| Issue | Title | Dependency |
|-------|-------|------------|
| LIS-055 | Sample Collection Recording API | Order state machine (LIS-041) |
| LIS-056 | Sample State Machine | LIS-055 |
| LIS-057 | Sample Barcode Scanning Integration | LIS-056 |
| LIS-058 | Sample Rejection & Recollection Workflow | LIS-056 |
| LIS-059 | Sample Receiving at Lab | LIS-057 |
| LIS-060 | Sample Aliquoting | LIS-059 |
| LIS-061 | Sample Storage & Location Tracking | LIS-059 |
| LIS-062 | Sample Disposal Workflow | LIS-061 |
| LIS-063 | Inter-branch Sample Transfer | LIS-059 |
| LIS-064 | TAT Monitoring & Alerts | LIS-060 |
| LIS-065 | Sample Inventory Tracking | LIS-061 |
| LIS-066 | Sample Module Angular screens (14 screens) | LIS-055 |
| LIS-067 | Barcode Scanner Hardware Integration | LIS-057 |
| LIS-068 | Sample SLA & KPI Reporting | LIS-064 |

**Backend module:** `lis-sample` (currently empty — 0 files)
**Frontend:** Scaffolded (`frontend/src/app/features/sample/`)

> **Phase 4 verdict: ⬜ 0% — Cannot start until LIS-041 (Order State Machine) is complete.**
> **Estimated effort: 4 weeks once Phase 3 is unblocked.**

---

## Phase 5 — Result Entry & Validation ⬜ NOT STARTED (0%)

**Timeline:** Months 8–12 | **Issues:** 20 (LIS-069 to LIS-088)

### Planned Deliverables

| Issue | Title | Notes |
|-------|-------|-------|
| LIS-069 | Result Entry Core API and State Machine | Foundation for all departments |
| LIS-070 | Biochemistry Result Entry | Numeric + calculated parameters |
| LIS-071 | Hematology Result Entry | CBC with 5-part diff; histograms |
| LIS-072 | Microbiology Result Entry | Culture + antibiogram (S/I/R) |
| LIS-073 | Histopathology Result Entry | Narrative + image attachments |
| LIS-074 | Clinical Pathology Result Entry | Urine routine, stool microscopy |
| LIS-075 | Serology/Immunology Result Entry | Qualitative + titre results |
| LIS-076 | Molecular Biology Result Entry | PCR CT values; gene targets |
| LIS-077 | Auto-calculation Engine | Derived parameters (e.g., eGFR, LDL) |
| LIS-078 | Delta Check Implementation | Compare with previous results |
| LIS-079 | Critical Value Detection & Notification | Trigger notification pipeline |
| LIS-080 | Auto-validation Engine | Rule-based auto-release |
| LIS-081 | Result Verification Workflow | Dual-sign for high-risk tests |
| LIS-082 | Result Authorization (e-signature) | Senior pathologist approval |
| LIS-083 | Result Amendment Workflow | Amended report tracking |
| LIS-084 | External Result Entry (referred tests) | External lab integration |
| LIS-085 | Result Entry Angular screens (20 screens) | Dept-specific UIs |
| LIS-086 | Authorization Angular screens (8 screens) | Pathologist dashboard |
| LIS-087 | Micro Antibiogram UI | S/I/R matrix |
| LIS-088 | Result Worklist API | Pending results by department |

**Backend module:** `lis-result` (currently empty — 0 files)
**Frontend:** Scaffolded (`frontend/src/app/features/result/`)

> **Phase 5 verdict: ⬜ 0% — Most complex phase (7 departments, 20 issues). Blocked by Phase 4.**
> **Estimated effort: 8 weeks.**

---

## Phase 6 — Instrument Interface ⬜ NOT STARTED (0%)

**Timeline:** Months 10–13 | **Issues:** 12 (LIS-089 to LIS-100)

### Planned Deliverables

| Issue | Title | Notes |
|-------|-------|-------|
| LIS-089 | ASTM E1381 TCP/IP Connection Manager | Netty or NIO; multi-instrument |
| LIS-090 | ASTM E1394 Frame Parser | STX/ETX framing; checksum |
| LIS-091 | Instrument Message Handler | Host Query, Result, Patient records |
| LIS-092 | Bidirectional Order Upload to Instruments | LIS → instrument worklist |
| LIS-093 | Auto-result Import from Instruments | Instrument → LIS via RabbitMQ |
| LIS-094 | Roche Cobas c311 Integration | Driver + test mapping |
| LIS-095 | Sysmex XN-1000 Integration | Driver + test mapping |
| LIS-096 | Instrument QC Data Collection | Level I/II/III auto-import |
| LIS-097 | Instrument Error Handling & Alerts | Connection drops; checksum errors |
| LIS-098 | Instrument Log & Audit Trail | All messages archived |
| LIS-099 | Instrument Management Angular screens (8 screens) | Config + status dashboard |
| LIS-100 | ASTM/HL7 Message Archive | MinIO storage for raw messages |

**Backend module:** `lis-instrument` (currently empty — 0 files)
**Frontend:** Scaffolded (`frontend/src/app/features/`)

> **Phase 6 verdict: ⬜ 0% — Can overlap with Phase 5 (starts month 10). Requires ASTM protocol expertise.**
> **Estimated effort: 4 weeks.**

---

## Phase 7 — Reports, QC & Notifications ⬜ NOT STARTED (0%)

**Timeline:** Months 12–16 | **Issues:** 17 (LIS-101 to LIS-117)

### Planned Deliverables

| Issue | Title | Module |
|-------|-------|--------|
| LIS-101 | PDF Report Generation Engine (OpenPDF) | `lis-report` |
| LIS-102 | Department-specific Report Layouts | `lis-report` |
| LIS-103 | Report Header & Branding (per branch) | `lis-report` |
| LIS-104 | Report Delivery (WhatsApp, Email, Portal) | `lis-notification` |
| LIS-105 | Report Angular screens (10 screens) | Frontend |
| LIS-106 | QC Material & Level Management | `lis-qc` |
| LIS-107 | QC Result Entry & Westgard Rules | `lis-qc` |
| LIS-108 | Levey-Jennings Chart Generation | `lis-qc` |
| LIS-109 | External QA / EQA Program Integration | `lis-qc` |
| LIS-110 | QC Angular screens (10 screens) | Frontend |
| LIS-111 | SMS/Email/WhatsApp Notification Engine | `lis-notification` |
| LIS-112 | Critical Value Notification (call + SMS) | `lis-notification` |
| LIS-113 | Report Ready Notification | `lis-notification` |
| LIS-114 | Notification Template Management | `lis-notification` |
| LIS-115 | Notification Angular screens (5 screens) | Frontend |
| LIS-116 | Inventory Management (reagents) | `lis-inventory` |
| LIS-117 | Inventory Angular screens (12 screens) | Frontend |

**Backend modules:** `lis-report`, `lis-qc`, `lis-notification`, `lis-inventory` (all empty — 0 files)
**Frontend:** Scaffolded

> **Phase 7 verdict: ⬜ 0% — High integration complexity (PDF + QC + multi-channel). Blocked by Phase 5.**
> **Estimated effort: 6 weeks.**

---

## Phase 8 — Portals, Analytics & Launch ⬜ NOT STARTED (0%)

**Timeline:** Months 16–22 | **Issues:** 18 (LIS-118 to LIS-135)

### Planned Deliverables

| Issue | Title | Notes |
|-------|-------|-------|
| LIS-118 | Doctor Portal Backend API | OAuth2; referral-scoped access |
| LIS-119 | Doctor Portal Angular App | Separate lazy-loaded module |
| LIS-120 | Patient Portal Backend API | OTP login; self-registration |
| LIS-121 | Patient Portal Angular App | Report download; appointment |
| LIS-122 | Home Collection Module | Route assignment; GPS tracking |
| LIS-123 | Analytics Dashboard APIs | Test TAT, revenue, popular tests |
| LIS-124 | Operational Reports | Branch, department, user reports |
| LIS-125 | Analytics Angular screens (dashboards) | Charts + KPIs |
| LIS-126 | Performance Testing | JMeter; 200 concurrent users |
| LIS-127 | Security Audit | OWASP Top 10; pen test |
| LIS-128 | FHIR R4 Integration | `lis-integration` |
| LIS-129 | HL7 v2 Integration | External labs |
| LIS-130 | Multi-language Support (i18n) | Frontend; 3 languages |
| LIS-131 | Accessibility (WCAG 2.1 AA) | Screen readers; keyboard nav |
| LIS-132 | Production Kubernetes Deployment | Helm charts; HPA |
| LIS-133 | Disaster Recovery & Backup | RTO 4h; RPO 1h |
| LIS-134 | User Acceptance Testing (UAT) | 2-branch pilot |
| LIS-135 | Production Launch & Handover | Go-live checklist |

**Backend module:** `lis-integration` (currently empty — 0 files)
**Frontend:** Portals scaffolded (`doctor-portal`, `patient-portal`)

> **Phase 8 verdict: ⬜ 0% — Final phase. Includes performance testing, security audit, and production launch.**
> **Estimated effort: 6 weeks + 6-8 weeks for UAT and launch preparation.**

---

## Implementation Metrics Summary

### Backend Module Status

```
Module             Files    Entities   Services   Controllers   Tests   Phase   Status
─────────────────────────────────────────────────────────────────────────────────────────
lis-core            9          1          0            0          8     1     ✅ Done
lis-auth            4          0          0            0          1     1     ✅ Done
lis-gateway         3          0          0            0          1     1     ✅ Done
lis-admin          154        30         26           26         21     2     🟡 ~85%
lis-patient         13         5          2            2          1     3     🟡 ~30%
lis-order           13         5          1            1          1     3     🟡 ~20%
lis-billing         24        10          4            4          2     3     🟡 ~30%
lis-sample           0         0          0            0          0     4     ⬜ 0%
lis-result           0         0          0            0          0     5     ⬜ 0%
lis-instrument       0         0          0            0          0     6     ⬜ 0%
lis-report           0         0          0            0          0     7     ⬜ 0%
lis-qc               0         0          0            0          0     7     ⬜ 0%
lis-notification     0         0          0            0          0     7     ⬜ 0%
lis-inventory        0         0          0            0          0     7     ⬜ 0%
lis-integration      0         0          0            0          0     8     ⬜ 0%
─────────────────────────────────────────────────────────────────────────────────────────
TOTAL              220        51         33           33         35
```

### Frontend Feature Status

```
Feature           Components   Models   Services   Tests   Status
─────────────────────────────────────────────────────────────────
admin                 42         25        3          0    🟡 No HTML/tests
patient                3          3        1          0    🟡 Scaffold only
order                  3          3        1          0    🟡 Scaffold only
billing                3          3        1          0    🟡 Scaffold only
sample                 1          0        0          0    ⬜ Scaffold only
result                 1          0        0          0    ⬜ Scaffold only
report                 1          0        0          0    ⬜ Scaffold only
qc                     1          0        0          0    ⬜ Scaffold only
inventory              1          0        0          0    ⬜ Scaffold only
dashboard              1          0        0          0    ⬜ Scaffold only
doctor-portal          1          0        0          0    ⬜ Scaffold only
patient-portal         1          0        0          0    ⬜ Scaffold only
─────────────────────────────────────────────────────────────────
TOTAL                 59         34        6          0
```

### Test Coverage

| Module | Test Files | Services Covered | Target | Gap |
|--------|-----------|-----------------|--------|-----|
| `lis-core` | 8 | N/A (utility tests) | — | — |
| `lis-admin` | 21 | 6 of 21 (29%) | 80% | **51 percentage points** |
| `lis-patient` | 1 | 1 of 2 (50%) | 80% | 30% gap |
| `lis-order` | 1 | 1 of 1 (100%) | 80% | — |
| `lis-billing` | 2 | 2 of 4 (50%) | 80% | 30% gap |
| `lis-auth` | 1 | Security config | — | — |
| `lis-gateway` | 1 | Gateway config | — | — |
| `lis-sample–lis-integration` | 0 | 0 | 80% | ∞ |
| **Frontend** | **0** | **0 of 59 components** | 70% | **∞** |

---

## Critical Path & Blockers

```
Phase 3 (Order State Machine) ──→ Phase 4 (Sample Lifecycle)
                                      │
                              Phase 5 (Result Entry)
                                 │          │
                          Phase 6 (Instruments, overlaps)
                                      │
                              Phase 7 (Reports, QC, Notifications)
                                      │
                              Phase 8 (Portals, Analytics, Launch)
```

### 🔴 Blocker 1 — Order State Machine (LIS-041)
Orders cannot transition through the workflow. Phase 4 cannot begin until resolved.
**Effort:** 3–5 days | **Owner:** Phase 3 team

### 🔴 Blocker 2 — Phase 2 Missing Entities (TASK-P2-01 to P2-04)
4 frontend screens call APIs that don't exist (runtime errors). Blocks Phase 2 sign-off.
**Effort:** 4–5 days | **Owner:** Phase 2 team

### 🟡 Risk 1 — Test Coverage (Phase 2)
29% coverage in `lis-admin`; target is 80%. 15 service tests need to be added.
**Effort:** 5–7 days

### 🟡 Risk 2 — Frontend HTML/SCSS Missing (Phase 2 Admin)
42 Angular components have TypeScript logic but no UI templates. Not usable in a browser.
**Effort:** 15–20 days (parallel)

### ✅ Risk 3 — Seed Data — RESOLVED (PR #16)
12 repeatable Flyway migrations (R__001–R__012) added: departments, sample types, antibiotics, microorganisms, CLSI breakpoints, units, roles/permissions, report templates, rejection reasons, number series, critical values.

---

## Effort Estimates (Remaining Work)

| Phase | Current | Target | Effort | Key Remaining Work |
|-------|---------|--------|--------|--------------------|
| Phase 2 | 90% | 100% | 2 wks (1 dev) | 4 missing entities, tests (×15), frontend HTML |
| Phase 3 | 30% | 100% | 6 wks | State machine, UHID, panel expansion, UI (34 screens) |
| Phase 4 | 0% | 100% | 4 wks | Full sample lifecycle, barcode scanning, state machine |
| Phase 5 | 0% | 100% | 8 wks | 7 depts, 20 issues, auto-calc, delta check, critical values |
| Phase 6 | 0% | 100% | 4 wks | ASTM TCP, frame parser, 2 instrument drivers, RabbitMQ |
| Phase 7 | 0% | 100% | 6 wks | PDF engine, Westgard QC, SMS/Email/WhatsApp, inventory |
| Phase 8 | 0% | 100% | 12 wks | Portals, analytics, perf test, security audit, UAT, launch |
| **Total remaining** | | | **~42.5 wks** | **~10–11 months** |

---

## Recommended Action Plan

### Immediate (Next 2 Weeks) — Complete Phase 2

1. **Create 4 missing backend entities** with full CRUD stacks (TASK-P2-01 to P2-04): `NotificationTemplate`, `ReportTemplate`, `DiscountScheme`, `InsuranceTariff`
   > ✅ `Role`/`Permission` (TASK-P2-05) — DB schema and seed data added in PR #16; Java stack already existed.
   > ✅ Seed data (TASK-P2-06) — 12 repeatable migrations added in PR #16.
2. **Add 15 service unit tests** to reach 80% coverage in `lis-admin` (TASK-P2-07)
3. **Add minimum frontend tests** for 4 critical admin components (TASK-P2-08)

### Short Term (Weeks 3–10) — Complete Phase 3

5. **Implement Order State Machine** with all transitions and event publishing
6. **Complete UHID generation** with pessimistic locking
7. **Implement panel expansion** for test-to-tube mapping
8. **Wire barcode generation** from `lis-core` utility to order creation
9. **Build 34 frontend screens** (patient, order, billing with HTML/SCSS/tests)

### Medium Term (Weeks 10–22) — Phase 4 + Phase 5 + Phase 6

10. Complete sample lifecycle (LIS-055 to LIS-068)
11. Implement result entry for all 7 departments (LIS-069 to LIS-088) — assign domain experts
12. Instrument ASTM integration (LIS-089 to LIS-100, overlapping with Phase 5)

### Long Term (Months 6–11) — Phase 7 + Phase 8

13. PDF reports, Westgard QC, notification engine, inventory (LIS-101 to LIS-117)
14. Doctor portal, patient portal, analytics dashboards (LIS-118 to LIS-125)
15. Performance test, security audit, UAT, production launch (LIS-126 to LIS-135)

---

## References

| Document | Location |
|----------|----------|
| Phase 1 issues | [phase-1-foundation.md](phase-1-foundation.md) |
| Phase 2 issues | [phase-2-administration.md](phase-2-administration.md) |
| Phase 2 detailed gap analysis | [phase-2-status-review.md](phase-2-status-review.md) |
| Phase 3 issues | [phase-3-patient-ordering.md](phase-3-patient-ordering.md) |
| Phase 4 issues | [phase-4-sample-management.md](phase-4-sample-management.md) |
| Phase 5 issues | [phase-5-result-entry.md](phase-5-result-entry.md) |
| Phase 6 issues | [phase-6-instrument-interface.md](phase-6-instrument-interface.md) |
| Phase 7 issues | [phase-7-reports-qc-notifications.md](phase-7-reports-qc-notifications.md) |
| Phase 8 issues | [phase-8-portals-analytics.md](phase-8-portals-analytics.md) |
| Pending task checklist (Phases 1–3) | [pending-tasks.md](pending-tasks.md) |
| Milestones README | [README.md](README.md) |
