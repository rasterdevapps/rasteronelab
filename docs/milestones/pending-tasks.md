# RasterOneLab LIS — Pending Task List (Phases 1–3)

> **Review Date:** 2026-03-19 (updated — PR #16 merged)
> **Scope:** Phases 1, 2, and 3 only
> **Overall Phase Status:** Phase 1 ✅ Done · Phase 2 🟡 ~90% · Phase 3 ⬜ Not Started

---

## Summary

| Phase | Total Issues | Done | Pending | Blocked |
|-------|-------------|------|---------|---------|
| Phase 1 — Foundation | 15 | 15 | **0** | — |
| Phase 2 — Administration | 18 | 15 | **3 (partial/missing)** | 1 critical |
| Phase 3 — Patient & Ordering | 21 | 0 | **21** | — |
| **Total** | **54** | **30** | **24** | — |

---

## ✅ Phase 1 — Foundation (COMPLETE — No Pending Tasks)

All 15 issues (LIS-001 to LIS-015) are fully implemented and verified.

| Issue | Title | Status |
|-------|-------|--------|
| LIS-001 | BaseEntity with UUID v7, audit fields, soft delete | ✅ Done |
| LIS-002 | ApiResponse and PagedResponse | ✅ Done |
| LIS-003 | Global exception handler and custom exceptions | ✅ Done |
| LIS-004 | BranchContextHolder and BranchInterceptor | ✅ Done |
| LIS-005 | BranchAwareRepository base interface | ✅ Done |
| LIS-006 | Keycloak realm configuration (10 roles, JWT claims, test users) | ✅ Done |
| LIS-007 | Spring Security OAuth2 Resource Server | ✅ Done |
| LIS-008 | Spring Cloud Gateway routing and JWT validation | ✅ Done |
| LIS-009 | Angular 19 application scaffold with authentication | ✅ Done |
| LIS-010 | Angular BranchInterceptor and BranchService | ✅ Done |
| LIS-011 | Shared Angular layout and navigation components | ✅ Done |
| LIS-012 | Docker Compose for all services | ✅ Done |
| LIS-013 | Jenkins CI/CD pipeline | ✅ Done |
| LIS-014 | Dockerfiles for backend and frontend | ✅ Done |
| LIS-015 | Flyway migration framework and core tables | ✅ Done |

> **Phase 1 verdict:** ✅ **100% complete. No action required.**

---

## 🟡 Phase 2 — Administration Module (PENDING TASKS)

> **Context:** 154 backend Java files, 42 frontend components, and 26 Flyway migrations are implemented. Phase 2 is blocked until the items below are resolved.

### 🔴 P0 — Critical Blockers (Must Fix Before Phase 2 is "Done")

#### TASK-P2-01 · Create missing backend entity: `NotificationTemplate`

**Issue:** LIS-032 (Configuration Screens — Frontend) has a `notification-template-list` and `notification-template-form` component, but the backend has no `NotificationTemplate` entity, service, controller, DTOs, mapper, or migration.

**Work required:**
- [ ] `NotificationTemplate` JPA entity extending `BaseEntity` (fields: `name`, `eventType`, `channel` [SMS/EMAIL/WHATSAPP], `subject`, `bodyTemplate`, `variables`, `isActive`)
- [ ] `NotificationTemplateRepository` extending `BranchAwareRepository`
- [ ] `NotificationTemplateService` with CRUD methods
- [ ] `NotificationTemplateController` with `@PreAuthorize` on all endpoints
- [ ] `NotificationTemplateRequest` / `NotificationTemplateResponse` DTOs
- [ ] `NotificationTemplateMapper` (MapStruct)
- [ ] Flyway forward + rollback migration: `V20260318_0015__notification_template.sql` / `U20260318_0015__notification_template.sql`
- [ ] Unit test: `NotificationTemplateServiceTest`

**Files to create:** ~8 Java files + 2 SQL migrations

---

#### TASK-P2-02 · Create missing backend entity: `ReportTemplate`

**Issue:** Frontend `report-template-list` and `report-template-form` components exist with no corresponding backend.

**Work required:**
- [ ] `ReportTemplate` JPA entity (fields: `name`, `departmentId`, `headerHtml`, `footerHtml`, `cssStyles`, `logoUrl`, `isDefault`, `isActive`)
- [ ] `ReportTemplateRepository` extending `BranchAwareRepository`
- [ ] `ReportTemplateService` with CRUD methods
- [ ] `ReportTemplateController` with `@PreAuthorize`
- [ ] `ReportTemplateRequest` / `ReportTemplateResponse` DTOs
- [ ] `ReportTemplateMapper` (MapStruct)
- [ ] Flyway forward + rollback migration: `V20260318_0016__report_template.sql`
- [ ] Unit test: `ReportTemplateServiceTest`

**Files to create:** ~8 Java files + 2 SQL migrations

---

#### TASK-P2-03 · Create missing backend entity: `DiscountScheme`

**Issue:** Frontend `discount-scheme-list` and `discount-scheme-form` components exist; backend has no `DiscountScheme` entity.

**Work required:**
- [ ] `DiscountScheme` JPA entity (fields: `name`, `discountType` [PERCENTAGE/FLAT/COUPON], `value`, `maxAmount`, `applicableTo` [PATIENT/CORPORATE/INSURANCE], `validFrom`, `validTo`, `isActive`)
- [ ] `DiscountSchemeRepository` extending `BranchAwareRepository`
- [ ] `DiscountSchemeService` with CRUD methods
- [ ] `DiscountSchemeController` with `@PreAuthorize`
- [ ] `DiscountSchemeRequest` / `DiscountSchemeResponse` DTOs
- [ ] `DiscountSchemeMapper` (MapStruct)
- [ ] Flyway forward + rollback migration: `V20260318_0017__discount_scheme.sql`
- [ ] Unit test: `DiscountSchemeServiceTest`

**Files to create:** ~8 Java files + 2 SQL migrations

---

#### TASK-P2-04 · Create missing backend entity: `InsuranceTariff`

**Issue:** Frontend `insurance-tariff-list` and `insurance-tariff-form` components exist; backend has no `InsuranceTariff` entity.

**Work required:**
- [ ] `InsuranceTariff` JPA entity (fields: `insuranceName`, `tariffCode`, `testMasterId`, `negotiatedPrice`, `claimLimit`, `preAuthRequired`, `validFrom`, `validTo`, `isActive`)
- [ ] `InsuranceTariffRepository` extending `BranchAwareRepository`
- [ ] `InsuranceTariffService` with CRUD methods
- [ ] `InsuranceTariffController` with `@PreAuthorize`
- [ ] `InsuranceTariffRequest` / `InsuranceTariffResponse` DTOs
- [ ] `InsuranceTariffMapper` (MapStruct)
- [ ] Flyway forward + rollback migration: `V20260318_0018__insurance_tariff.sql`
- [ ] Unit test: `InsuranceTariffServiceTest`

**Files to create:** ~8 Java files + 2 SQL migrations

---

#### ✅ TASK-P2-05 · `Role` and `Permission` — RESOLVED (PR #16)

DB schema (`V20260318_0016__create_role_permission_tables.sql`) and seed data (`R__008_seed_roles_permissions.sql`: 10 system roles, 23 permissions, full role-permission matrix) were added in PR #16. The Java CRUD stack (`Role.java`, `RoleRepository`, `RoleService`, `RoleController`, `RoleMapper`, `RoleRequest`, `RoleResponse`) already existed.

**Remaining:**
- [ ] Verify Keycloak Admin API sync in `AppUserService`
- [ ] Unit test: `RoleServiceTest`

---

#### ✅ TASK-P2-06 · Seed data migrations — RESOLVED (PR #16)

**12 repeatable Flyway seed migrations merged in PR #16:**
- [x] `R__001_seed_departments.sql` — 11 standard lab departments
- [x] `R__002_seed_sample_types.sql` — 15 sample/tube types
- [x] `R__003_seed_antibiotics.sql` — 60+ antibiotics across 17 CLSI drug classes
- [x] `R__004_seed_microorganisms.sql` — 80+ microorganisms
- [x] `R__005_seed_organism_antibiotic_panels.sql` — 11 default antibiotic panels
- [x] `R__006_seed_clsi_breakpoints.sql` — 47 CLSI M100 2024 breakpoints
- [x] `R__007_seed_units.sql` — 46 measurement units
- [x] `R__008_seed_roles_permissions.sql` — 10 roles, 23 permissions, full matrix
- [x] `R__009_seed_report_templates.sql` — default templates for all 11 departments
- [x] `R__010_seed_rejection_reasons.sql` — 15 rejection reasons with severity flags
- [x] `R__011_seed_number_series.sql` — 7 number series patterns (UHID, ORDER, SAMPLE, etc.)
- [x] `R__012_seed_critical_values.sql` — 18 critical value references

All seeds use `ON CONFLICT … DO NOTHING` or `WHERE NOT EXISTS` for idempotency.

---

### 🟡 P1 — High Priority (Required for Phase 2 Acceptance)

#### TASK-P2-07 · Increase backend test coverage from ~29% to ≥80%

**Issue:** Phase 2 acceptance criteria require 80% coverage on `lis-admin`. Currently only 6 of 21 services have tests.

**Services needing unit tests (15 missing):**

| Service | File |
|---------|------|
| OrganizationService | `OrganizationServiceTest.java` |
| BranchService | `BranchServiceTest.java` |
| DepartmentService | `DepartmentServiceTest.java` |
| BranchDepartmentService | `BranchDepartmentServiceTest.java` |
| TestMasterService | `TestMasterServiceTest.java` |
| ParameterService | `ParameterServiceTest.java` |
| ReferenceRangeService | `ReferenceRangeServiceTest.java` |
| TestPanelService | `TestPanelServiceTest.java` |
| TATConfigurationService | `TATConfigurationServiceTest.java` |
| WorkingHoursService | `WorkingHoursServiceTest.java` |
| HolidayService | `HolidayServiceTest.java` |
| DeltaCheckConfigService | `DeltaCheckConfigServiceTest.java` |
| AutoValidationRuleService | `AutoValidationRuleServiceTest.java` |
| MicroorganismService | `MicroorganismServiceTest.java` |
| AntibioticOrganismMappingService | `AntibioticOrganismMappingServiceTest.java` |

**Work required per service:**
- [ ] Mock repository with `@ExtendWith(MockitoExtension.class)`
- [ ] Test `create`, `update`, `delete`, `findById`, `findAll` methods
- [ ] Test branch isolation (branchId filtering)
- [ ] Test not-found scenarios (should throw `NotFoundException`)

---

#### TASK-P2-08 · Add frontend unit tests for critical admin components

**Issue:** 0 `.spec.ts` files exist for 42 frontend components.

**Work required (minimum viable coverage — highest-risk components):**
- [ ] `branch-list.component.spec.ts` — test data table, search, pagination
- [ ] `branch-form.component.spec.ts` — test form validation, create/edit flows
- [ ] `test-master-list.component.spec.ts` — test filters, data binding
- [ ] `test-master-form.component.spec.ts` — test parameter assignment
- [ ] `user-list.component.spec.ts` — test role/branch display
- [ ] `user-form.component.spec.ts` — test Keycloak role integration
- [ ] `role-list.component.spec.ts` — test permission matrix rendering

---

### 🟢 P2 — Nice to Have (Should Complete Before Phase 3 Start)

#### TASK-P2-09 · Add OpenAPI `@Operation` annotations to all 21 controllers

**Issue:** SpringDoc is configured and auto-generates from code, but no `@Tag`, `@Operation`, or `@ApiResponse` annotations provide human-readable documentation.

**Work required:**
- [ ] Add `@Tag(name = "...", description = "...")` on each controller class
- [ ] Add `@Operation(summary = "...", description = "...")` on each endpoint method
- [ ] Add `@ApiResponse` for common status codes (200, 400, 404, 409)
- [ ] Add example request/response bodies via `@Schema` on DTOs

---

#### TASK-P2-10 · Implement branch provisioning wizard

**Issue:** LIS-029. There is no guided multi-step dialog for setting up a new branch (working hours, departments, number series).

**Work required:**
- [ ] Multi-step Angular Material `MatStepper` dialog component
- [ ] Step 1: Branch basic info (name, code, type, address)
- [ ] Step 2: Assign departments (checkbox list from org departments)
- [ ] Step 3: Configure working hours (reuse `working-hours-form`)
- [ ] Step 4: Set number series prefixes per document type
- [ ] Confirmation step with summary

---

#### TASK-P2-11 · Verify reference range overlap validation

**Issue:** LIS-021. The acceptance criteria require that overlapping age/gender reference ranges for the same parameter cannot be saved, but this logic has not been verified.

**Work required:**
- [ ] Review `ReferenceRangeService.create()` for overlap check
- [ ] If missing: add validation that no two ranges for the same `parameterId` + `gender` overlap in age range
- [ ] Add unit test covering overlap scenario

---

#### TASK-P2-12 · Verify branch override pricing logic in `PriceCatalogService`

**Issue:** LIS-023. Acceptance criteria include branch-level price overrides (branch price takes precedence over org-level price), but this logic has not been verified.

**Work required:**
- [ ] Review `PriceCatalogService` for branch override logic
- [ ] If missing: implement price resolution order (branch → org → default)
- [ ] Add unit test: branch price overrides org price for same test

---

## ⬜ Phase 3 — Patient & Ordering (ALL TASKS PENDING)

> **Context:** `lis-patient`, `lis-order`, and `lis-billing` are stub modules. Phase 3 has not started. All 21 issues are pending.

### Backend — Patient Module (`lis-patient`)

#### TASK-P3-01 · LIS-034: Patient CRUD API with UHID generation

- [ ] `Patient` JPA entity: name, DOB, age, gender, phone, email, address, bloodGroup, UHID
- [ ] UHID generation: `{BranchCode}-{6-digit-sequence}` with pessimistic locking via `NumberSeries`
- [ ] `PatientService` with CRUD + search (by phone, name, UHID)
- [ ] `PatientController` with `@PreAuthorize`
- [ ] Patient DTOs + MapStruct mapper
- [ ] PHI access audit logging
- [ ] Flyway migration: `patient` table
- [ ] Unit + integration tests (80% coverage target)

---

#### TASK-P3-02 · LIS-035: Duplicate Patient Detection and Merge

- [ ] Duplicate detection: name + DOB match, phone match (weighted scoring algorithm)
- [ ] `PatientMergeService`: select primary patient, transfer orders/results to primary, deactivate duplicate
- [ ] Merge audit trail: log which records were merged and by whom
- [ ] Endpoints: `GET /api/v1/patients/duplicates`, `POST /api/v1/patients/merge`
- [ ] Integration tests for merge scenarios

---

#### TASK-P3-03 · LIS-036: Patient Visit Management

- [ ] `PatientVisit` JPA entity: patient, visitDate, visitType (WALK_IN/APPOINTMENT/HOME_COLLECTION), referringDoctor
- [ ] Auto-create visit on new order placement
- [ ] Visit history with order/result summary
- [ ] Endpoints: `GET /api/v1/patients/{id}/visits`, `POST`, `PUT`
- [ ] Flyway migration: `patient_visit` table
- [ ] Unit tests

---

### Backend — Order Module (`lis-order`)

#### TASK-P3-04 · LIS-037: Test Order Creation API with state machine

- [ ] `TestOrder` JPA entity: patient, visit, referringDoctor, priority (ROUTINE/STAT/URGENT), status, orderDate
- [ ] `OrderLineItem` entity: test, parameters, sampleType, tubeType, status
- [ ] Order state machine: `DRAFT → PLACED → PAID → SAMPLE_COLLECTED → IN_PROGRESS → RESULTED → AUTHORISED → COMPLETED` (also `CANCELLED`)
- [ ] Order barcode format: `ORD-{BranchCode}-{YYYYMMDD}-{sequence}`
- [ ] Endpoints: `POST /api/v1/orders`, `GET`, `PUT /{id}/place`, `PUT /{id}/cancel`
- [ ] Flyway migrations: `test_order`, `order_line_item` tables
- [ ] Unit + integration tests

---

#### TASK-P3-05 · LIS-038: Panel Expansion and Test Search

- [ ] Test search endpoint: `GET /api/v1/tests/search?q=&departmentId=` with partial matching
- [ ] Panel expansion: `GET /api/v1/panels/{id}/expand` — recursive expansion of nested panels
- [ ] De-duplication: if same test appears in multiple selected panels, add it only once
- [ ] Reflex test rule engine: auto-add follow-up tests based on result conditions (rule config in admin)
- [ ] Unit tests for panel expansion recursion and de-duplication

---

#### TASK-P3-06 · LIS-039: Order Validation and Sample Requirements

- [ ] `OrderValidationService`: validate all required fields, check sample requirements
- [ ] Sample grouping logic: group order line items by sample type and tube type
- [ ] TAT calculation per test based on `TATConfiguration`
- [ ] Insurance/corporate pre-authorization check (if applicable)
- [ ] Pending collection list generation per tube type
- [ ] Unit tests for validation scenarios

---

### Backend — Billing Module (`lis-billing`)

#### TASK-P3-07 · LIS-040: Invoice Generation API

- [ ] `Invoice` JPA entity: order, patient, items, subtotal, discountAmount, taxAmount, totalAmount, status
- [ ] `InvoiceLineItem` entity: test, quantity, unitPrice, discountAmount, netAmount
- [ ] Pricing logic: base price → branch override → rate list (WALK_IN/CORPORATE/INSURANCE/DOCTOR_REF) → discount
- [ ] Invoice state machine: `DRAFT → GENERATED → PARTIALLY_PAID → PAID → REFUNDED`
- [ ] Invoice number: `INV-{BranchCode}-{YYYYMMDD}-{sequence}`
- [ ] Endpoints: `POST /api/v1/invoices/generate`, `GET /{id}`, `GET` (list)
- [ ] Flyway migrations: `invoice`, `invoice_line_item` tables
- [ ] Unit + integration tests

---

#### TASK-P3-08 · LIS-041: Payment Recording API

- [ ] `Payment` JPA entity: invoice, amount, paymentMethod (CASH/CARD/UPI/INSURANCE/CREDIT/ONLINE), transactionRef, receivedBy
- [ ] Split payment: multiple `Payment` rows per `Invoice`
- [ ] Partial payment: track remaining balance on invoice
- [ ] Receipt number generation via `NumberSeries`
- [ ] Endpoints: `POST /api/v1/payments`, `GET /api/v1/invoices/{id}/payments`
- [ ] Flyway migration: `payment` table
- [ ] Unit tests (split payment, partial payment, balance calculation)

---

#### TASK-P3-09 · LIS-042: Discount, Refund, and Outstanding Management

- [ ] Discount application: apply `DiscountScheme` to invoice with approval workflow for amounts above threshold
- [ ] `CreditAccount` entity: corporate/insurance running balance with credit limit
- [ ] Refund workflow: `Refund` entity, status (`REQUESTED → APPROVED → PROCESSED`), credit note generation
- [ ] Outstanding invoice tracking: `GET /api/v1/invoices/outstanding?patientId=&corporateId=`
- [ ] Endpoints: `POST /api/v1/invoices/{id}/discount`, `POST /api/v1/invoices/{id}/refund`
- [ ] Flyway migrations: `refund`, `credit_account` tables
- [ ] Unit tests

---

### Frontend — Patient Screens (`lis-patient` Angular feature module)

#### TASK-P3-10 · LIS-043: Patient Search and List screen (Screen #14)

- [ ] `patient-list` standalone Angular component
- [ ] Material data table: columns UHID, Name, Age/Gender, Phone, Last Visit
- [ ] Debounced search input (UHID / phone / name)
- [ ] Filter sidebar: date range, gender, status
- [ ] Quick action buttons: View, Edit, New Order
- [ ] Server-side pagination with `PagedResponse`
- [ ] Signal-based state management

---

#### TASK-P3-11 · LIS-044: Patient Registration and Edit screens (Screens #15-16)

- [ ] `patient-register` form component
- [ ] `patient-edit` form component (pre-populate from patient DTO)
- [ ] Mandatory fields: name, DOB/age, gender, phone; optional: email, address, bloodGroup
- [ ] Age ↔ DOB auto-calculator
- [ ] Duplicate detection warning dialog before save (calls `GET /api/v1/patients/duplicates`)
- [ ] Reactive form with Angular validators and error messages

---

#### TASK-P3-12 · LIS-045: Patient Detail and Visit History screens (Screens #17-25)

- [ ] `patient-detail` tabbed component: Demographics | Visit History | Order History | Reports | Billing
- [ ] `patient-visit-history` component: list of visits with test summary
- [ ] `patient-order-history` component: order list with status chips
- [ ] `patient-report-history` component: PDF download links
- [ ] `patient-billing-summary` component: outstanding balance, invoice list
- [ ] `patient-merge` component: duplicate list, merge confirmation dialog

---

### Frontend — Order Screens (`lis-order` Angular feature module)

#### TASK-P3-13 · LIS-046: Create Order wizard — 3-step stepper (Screens #26-28)

- [ ] `order-create` component with `MatStepper`
- [ ] Step 1: Patient search/select or quick-register inline
- [ ] Step 2: Test selection — search autocomplete, department filter, panel expansion chip list
- [ ] Step 3: Review — price breakdown, discount input, referring doctor, priority selector, confirm
- [ ] Order barcode display + print after successful submission

---

#### TASK-P3-14 · LIS-047: Order List, Detail, and Management screens (Screens #29-35)

- [ ] `order-list` component: status filters (DRAFT/PLACED/PAID/…), date range, search
- [ ] `order-detail` component: line items table, status timeline stepper, linked invoice
- [ ] `order-edit` component (DRAFT state only — restrict editing after PLACED)
- [ ] `order-cancel` dialog: cancel reason selector + confirm
- [ ] Barcode print button
- [ ] `pending-orders` dashboard widget: grouped by TAT urgency (green/amber/red)
- [ ] TAT monitor: colour-coded remaining time per order

---

### Frontend — Billing Screens (`lis-billing` Angular feature module)

#### TASK-P3-15 · LIS-048: Invoice and Payment screens (Screens #88-99)

- [ ] `invoice-list` component: status filter, date range, patient search
- [ ] `invoice-detail` component: line items, discount breakdown, payment history
- [ ] `payment-form` component: multi-method split payment UI (add/remove payment rows)
- [ ] Receipt print layout (printable CSS)
- [ ] `refund-form` component: reason, amount, approval workflow
- [ ] `outstanding-invoices` component: aging buckets (0-30/31-60/61-90/>90 days)
- [ ] Discount application dialog (scheme selector + override input)

---

### Cross-Cutting (Phase 3)

#### TASK-P3-16 · LIS-049: Spring Events for Order → Invoice auto-generation

- [ ] `OrderPlacedEvent` (published on `DRAFT → PLACED` transition)
- [ ] `PaymentReceivedEvent` (published when invoice becomes `PAID`)
- [ ] `InvoiceService` `@EventListener` for `OrderPlacedEvent` → auto-generate invoice
- [ ] `OrderService` `@EventListener` for `PaymentReceivedEvent` → update order to `PAID`
- [ ] Event audit logging
- [ ] Integration tests for event flow

---

#### TASK-P3-17 · LIS-050: Barcode Generation Service

- [ ] `BarcodeGenerationService` in `lis-core` (or `lis-order`):
  - Order barcode: `ORD-{BranchCode}-{YYYYMMDD}-{sequence}` (Code128)
  - Sample barcode: `SMP-{BranchCode}-{YYYYMMDD}-{sequence}` (Code128)
  - UHID: `{BranchCode}-{6-digit-sequence}` (generated on patient create)
- [ ] `NumberSeries` atomic increment with branch isolation (already exists in `lis-admin` — expose via event or shared service)
- [ ] Barcode image rendering (Base64 PNG via `zxing` or `barcode4j`)
- [ ] Unit tests: barcode format validation, sequence uniqueness

---

#### TASK-P3-18 · LIS-051: Flyway migrations for Patient, Order, and Billing tables

- [ ] `patient` table migration (if not already complete from Phase 1)
- [ ] `patient_visit` table migration
- [ ] `test_order`, `order_line_item` table migrations
- [ ] `invoice`, `invoice_line_item`, `payment`, `refund`, `credit_account` tables
- [ ] Number series entries for: PATIENT_UHID, ORDER_BARCODE, SAMPLE_BARCODE, INVOICE_NUMBER, RECEIPT_NUMBER
- [ ] Foreign keys and performance indexes
- [ ] Dev seed data (test patients, sample orders)
- [ ] Rollback scripts for all migrations

---

#### TASK-P3-19 · LIS-052: End-to-end integration test: Patient → Order → Invoice → Payment

- [ ] Testcontainers setup: PostgreSQL + Keycloak
- [ ] Happy path test:
  1. Register new patient → assert UHID generated
  2. Create order with CBC + Lipid Panel → assert panel expanded to constituent tests
  3. Place order → assert `OrderPlacedEvent` fired → assert invoice auto-generated
  4. Record payment (full CASH) → assert invoice status `PAID`, order status `PAID`
- [ ] Partial payment test (split CASH + UPI)
- [ ] Multi-branch isolation test (orders from branch A not visible from branch B)
- [ ] Error scenarios: duplicate patient, cancelled order, refund flow

---

#### TASK-P3-20 · LIS-053: OpenAPI documentation for Patient, Order, and Billing APIs

- [ ] `@Tag`, `@Operation`, `@ApiResponse` annotations on all 3 module controllers
- [ ] Request/response examples in `@Schema`
- [ ] Swagger UI accessible at `/swagger-ui.html`
- [ ] Postman collection exported and committed to `docs/api/`

---

#### TASK-P3-21 · LIS-054: Implement Complete Lipid + CBC Walkthrough integration test

Based on `docs/process-flows/complete-lipid-cbc-walkthrough.md`:

- [ ] Register patient Rajesh Kumar (male, 45 years)
- [ ] Order Lipid Profile + CBC + ESR (panel expansion: Lipid → TC/TG/HDL/LDL/VLDL)
- [ ] Apply WALK_IN pricing
- [ ] Record CASH payment
- [ ] Assert all intermediate states match documentation walkthrough

---

## 📋 Master Pending Task Checklist

### Phase 2 Pending (18 tasks)

**P0 — Blockers**
- [ ] TASK-P2-01: Backend entity `NotificationTemplate` (full CRUD stack + migration + test)
- [ ] TASK-P2-02: Backend entity `ReportTemplate` (full CRUD stack + migration + test)
- [ ] TASK-P2-03: Backend entity `DiscountScheme` (full CRUD stack + migration + test)
- [ ] TASK-P2-04: Backend entity `InsuranceTariff` (full CRUD stack + migration + test)
- [x] ~~TASK-P2-05: Backend entities `Role` and `Permission` + AppUser link + Keycloak sync~~ ✅ **DONE (PR #16)**
- [x] ~~TASK-P2-06: Seed data migrations (11 departments, antibiotics, microorganisms)~~ ✅ **DONE (PR #16 — R__001–R__012)**

**P1 — High Priority**
- [ ] TASK-P2-07: Backend test coverage 29% → 80% (add 15 service unit tests)
- [ ] TASK-P2-08: Frontend unit tests for 7 critical admin components

**P2 — Nice to Have**
- [ ] TASK-P2-09: OpenAPI `@Operation` annotations on 21 admin controllers
- [ ] TASK-P2-10: Branch provisioning wizard (multi-step `MatStepper` dialog)
- [ ] TASK-P2-11: Reference range overlap validation + test
- [ ] TASK-P2-12: Branch override pricing logic verification + test

### Phase 3 Pending (21 tasks — not yet started)

**Backend**
- [ ] TASK-P3-01: LIS-034 Patient CRUD API with UHID generation
- [ ] TASK-P3-02: LIS-035 Duplicate patient detection and merge
- [ ] TASK-P3-03: LIS-036 Patient visit management
- [ ] TASK-P3-04: LIS-037 Test order creation API with state machine
- [ ] TASK-P3-05: LIS-038 Panel expansion and test search
- [ ] TASK-P3-06: LIS-039 Order validation and sample requirements
- [ ] TASK-P3-07: LIS-040 Invoice generation API
- [ ] TASK-P3-08: LIS-041 Payment recording API
- [ ] TASK-P3-09: LIS-042 Discount, refund, and outstanding management

**Frontend**
- [ ] TASK-P3-10: LIS-043 Patient search and list screen
- [ ] TASK-P3-11: LIS-044 Patient registration and edit screens
- [ ] TASK-P3-12: LIS-045 Patient detail and visit history screens
- [ ] TASK-P3-13: LIS-046 Create order wizard (3-step)
- [ ] TASK-P3-14: LIS-047 Order list, detail, and management screens
- [ ] TASK-P3-15: LIS-048 Invoice and payment screens

**Cross-cutting**
- [ ] TASK-P3-16: LIS-049 Spring Events: Order → Invoice auto-generation
- [ ] TASK-P3-17: LIS-050 Barcode generation service
- [ ] TASK-P3-18: LIS-051 Flyway migrations (Patient, Order, Billing tables)
- [ ] TASK-P3-19: LIS-052 End-to-end integration test
- [ ] TASK-P3-20: LIS-053 OpenAPI documentation for Phase 3 APIs
- [ ] TASK-P3-21: LIS-054 Lipid + CBC walkthrough integration test

---

## 🗓️ Suggested Sprint Plan

### Sprint 1 (Week 1-2): Clear Phase 2 Blockers
| Task | Owner | Effort |
|------|-------|--------|
| TASK-P2-01 to P2-04 | Backend Dev | 4 × 1 day = 4 days |
| ~~TASK-P2-05 (Role/Permission)~~ | ✅ Done (PR #16) | — |
| ~~TASK-P2-06 (Seed data)~~ | ✅ Done (PR #16) | — |
| **Sprint 1 Total** | | **~4 backend days** |

### Sprint 2 (Week 3-4): Phase 2 Quality & Phase 3 Setup
| Task | Owner | Effort |
|------|-------|--------|
| TASK-P2-07 (15 service tests) | Backend Dev | 5 days |
| TASK-P2-08 (Frontend tests) | Frontend Dev | 3 days |
| TASK-P2-09 to P2-12 (polish) | Both | 3 days |
| **Sprint 2 Total** | | **~11 days** |

### Sprint 3-6 (Month 2-3): Phase 3 Implementation
| Task Group | Owner | Effort |
|------------|-------|--------|
| Patient module (TASK-P3-01 to P3-03) | Backend Dev | 8 days |
| Order module (TASK-P3-04 to P3-06) | Backend Dev | 8 days |
| Billing module (TASK-P3-07 to P3-09) | Backend Dev | 8 days |
| Patient frontend (TASK-P3-10 to P3-12) | Frontend Dev | 6 days |
| Order frontend (TASK-P3-13 to P3-14) | Frontend Dev | 6 days |
| Billing frontend (TASK-P3-15) | Frontend Dev | 4 days |
| Cross-cutting (TASK-P3-16 to P3-21) | Both | 8 days |
| **Phase 3 Total** | | **~48 days** |
