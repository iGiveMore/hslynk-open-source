DROP SCHEMA IF EXISTS "stagv2014" cascade;
CREATE SCHEMA "stagv2014";
DROP SEQUENCE IF EXISTS "stagv2014".bulk_upload_id_seq;

DROP TABLE IF EXISTS "stagv2014".hmis_type;
DROP TABLE IF EXISTS "stagv2014".path_status;
DROP TABLE IF EXISTS "stagv2014".rhybcp_status;
DROP TABLE IF EXISTS "stagv2014".last_perm_address;
DROP TABLE IF EXISTS "stagv2014".percent_ami;
DROP TABLE IF EXISTS "stagv2014".lastgradecompleted;
DROP TABLE IF EXISTS "stagv2014".schoolstatus;
DROP TABLE IF EXISTS "stagv2014".employment;

DROP TABLE IF EXISTS "stagv2014".health_status;
DROP TABLE IF EXISTS "stagv2014".affiliation;
DROP TABLE IF EXISTS "stagv2014".site;
DROP TABLE IF EXISTS "stagv2014".inventory;
DROP TABLE IF EXISTS "stagv2014".funder;	
DROP TABLE IF EXISTS "stagv2014".enrollment_coc;

DROP TABLE IF EXISTS "stagv2014".rhybcpstatus;
DROP TABLE IF EXISTS "stagv2014".sexualorientation;
DROP TABLE IF EXISTS "stagv2014".formerwardjuvenilejustice;
DROP TABLE IF EXISTS "stagv2014".lastpermanentaddress;
DROP TABLE IF EXISTS "stagv2014".percentami;
DROP TABLE IF EXISTS "stagv2014".medicalassistance;
DROP TABLE IF EXISTS "stagv2014".youthcriticalissues;
DROP TABLE IF EXISTS "stagv2014".formerwardchildwelfare;
DROP TABLE IF EXISTS "stagv2014".referralsource;
DROP TABLE IF EXISTS "stagv2014".commercialsexualexploitation;
DROP TABLE IF EXISTS "stagv2014".domesticviolence;
DROP TABLE IF EXISTS "stagv2014".disabilities;
DROP TABLE IF EXISTS "stagv2014".residentialmoveindate;
DROP TABLE IF EXISTS "stagv2014".dateofengagement;
DROP TABLE IF EXISTS "stagv2014".services;
DROP TABLE IF EXISTS "stagv2014".incomeandsources;
DROP TABLE IF EXISTS "stagv2014".noncashbenefits;
DROP TABLE IF EXISTS "stagv2014".healthinsurance;
DROP TABLE IF EXISTS "stagv2014".exithousingassessment;
DROP TABLE IF EXISTS "stagv2014".exitplansactions;
DROP TABLE IF EXISTS "stagv2014".housingassessmentdisposition;
DROP TABLE IF EXISTS "stagv2014".familyreunification;
DROP TABLE IF EXISTS "stagv2014".connectionwithsoar;
DROP TABLE IF EXISTS "stagv2014".projectcompletionstatus;
DROP  table IF EXISTS  "stagv2014".worsthousingsituation;
DROP TABLE IF EXISTS "stagv2014".exit;
DROP TABLE IF EXISTS "stagv2014".bedinventory;
DROP TABLE IF EXISTS "stagv2014".projectcoc;
DROP TABLE IF EXISTS "stagv2014".project; 
DROP TABLE IF EXISTS "stagv2014".enrollment;
DROP TABLE IF EXISTS "stagv2014".organization; 
DROP TABLE IF  EXISTS "stagv2014".sync;
DROP TABLE IF EXISTS "stagv2014".veteran_info;
DROP TABLE IF EXISTS "stagv2014".client;


DROP TABLE IF EXISTS "stagv2014".bulk_upload;
DROP TABLE IF EXISTS "stagv2014".export; 
DROP TABLE IF EXISTS "stagv2014".source;


-- Table: "stagv2014"."client"


DROP TYPE IF EXISTS "stagv2014".name_data_quality;
DROP TYPE IF EXISTS "stagv2014".dob_data_quality;
DROP TYPE IF EXISTS "stagv2014".ssn_data_quality;
DROP TYPE IF EXISTS "stagv2014".address_data_quality;
DROP TYPE IF EXISTS "stagv2014".veteran_status;
DROP TYPE IF EXISTS "stagv2014".race;
DROP TYPE IF EXISTS "stagv2014".gender;
DROP TYPE IF EXISTS "stagv2014".ethnicity;
DROP TYPE IF EXISTS "stagv2014".afghanistanoef;
DROP TYPE IF EXISTS "stagv2014".desertstorm;
DROP TYPE IF EXISTS "stagv2014".asked_forced_exchange_sex;
DROP TYPE IF EXISTS "stagv2014".assessment_disposition;
DROP TYPE IF EXISTS "stagv2014".availability;
DROP TYPE IF EXISTS "stagv2014".bed_type;
DROP TYPE IF EXISTS "stagv2014".count_of_exchange_sex;
DROP TYPE IF EXISTS "stagv2014".destination;
DROP TYPE IF EXISTS "stagv2014".disability_type;
DROP TYPE IF EXISTS "stagv2014".discharge_status;
DROP TYPE IF EXISTS "stagv2014".early_exit_reason;
DROP TYPE IF EXISTS "stagv2014".employment_type;
DROP TYPE IF EXISTS "stagv2014".federal_partner_components;
DROP TYPE IF EXISTS "stagv2014".five_val_dk_refused;
DROP TYPE IF EXISTS "stagv2014".fysb_rsn_not_providing_srvcs;
DROP TYPE IF EXISTS "stagv2014".health_category;
DROP TYPE IF EXISTS "stagv2014".health_status_type;
DROP TYPE IF EXISTS "stagv2014".house_hold_type;
DROP TYPE IF EXISTS "stagv2014".housing_assmnt_exit;
DROP TYPE IF EXISTS "stagv2014".homeless_atrisk_status;
DROP TYPE IF EXISTS "stagv2014".incarcerated_parent_status;	
DROP TYPE IF EXISTS "stagv2014".issues_number_of_years;
DROP TYPE IF EXISTS "stagv2014".last_grade_completed;
DROP TYPE IF EXISTS "stagv2014".military_branch;
DROP TYPE IF EXISTS "stagv2014".months_homeless_past_3_years;
DROP TYPE IF EXISTS "stagv2014".no_adap_reason;
DROP TYPE IF EXISTS "stagv2014".no_health_insurance_reason;
DROP TYPE IF EXISTS "stagv2014".no_medical_assistance_reason;
DROP TYPE IF EXISTS "stagv2014".not_employed_reason;
DROP TYPE IF EXISTS "stagv2014".no_yes;
DROP TYPE IF EXISTS "stagv2014".no_yes_refused;
DROP TYPE IF EXISTS "stagv2014".path_how_confirmed;	
DROP TYPE IF EXISTS "stagv2014".path_smi_info_how_confirmed;
DROP TYPE IF EXISTS "stagv2014".percentage_ami;
DROP TYPE IF EXISTS "stagv2014".project_completion_status;
DROP TYPE IF EXISTS "stagv2014".project_type;
DROP TYPE IF EXISTS "stagv2014".reason_not_enrolled;	
DROP TYPE IF EXISTS "stagv2014".record_type;
DROP TYPE IF EXISTS "stagv2014".referral_outcome;
DROP TYPE IF EXISTS "stagv2014".referral_source;
DROP TYPE IF EXISTS "stagv2014".relationship_to_head_of_household;
DROP TYPE IF EXISTS "stagv2014".residence_prior ;
DROP TYPE IF EXISTS "stagv2014".residence_prior_length_of_stay;
DROP TYPE IF EXISTS "stagv2014".school_status;
DROP TYPE IF EXISTS "stagv2014".sexual_orientation;	
DROP TYPE IF EXISTS "stagv2014".subsidy_information;
DROP TYPE IF EXISTS "stagv2014".target_population_type;
DROP TYPE IF EXISTS "stagv2014".times_homeless_past_3_years;
DROP TYPE IF EXISTS "stagv2014".tracking_method;
DROP TYPE IF EXISTS "stagv2014".when_dom_violence_occurred;
DROP TYPE IF EXISTS "stagv2014".youth_age_group;
DROP TYPE IF EXISTS "stagv2014".housing_status;
DROP TYPE IF EXISTS "stagv2014".state;



CREATE TYPE "stagv2014".name_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "stagv2014".dob_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "stagv2014".ssn_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "stagv2014".address_data_quality AS ENUM ('1', '2', '8','9','99');

CREATE TYPE "stagv2014".veteran_status AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "stagv2014".race AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "stagv2014".gender AS ENUM ('1', '2','3','4','8','9','99');
CREATE TYPE "stagv2014".ethnicity AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "stagv2014".afghanistanoef AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "stagv2014".desertstorm AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "stagv2014".asked_forced_exchange_sex AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "stagv2014".assessment_disposition AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','14');
CREATE TYPE "stagv2014".availability AS ENUM ('1', '2', '3');
CREATE TYPE "stagv2014".bed_type AS ENUM ('1', '2', '3');
CREATE TYPE "stagv2014".count_of_exchange_sex AS ENUM ('1', '2', '3','4','8','9');
CREATE TYPE "stagv2014".destination AS ENUM 
('24','1','15','6','14','7','25','26','27','11','21','3','16','4','10','19','28','20','29','18','22','12','23','13','5','2','17','30','8','9','99');
CREATE TYPE "stagv2014".disability_type AS ENUM ('5','6','7','8','9','10');
CREATE TYPE "stagv2014".discharge_status AS ENUM ('1','2','4','5','6','7','8','9','99');
CREATE TYPE "stagv2014".early_exit_reason AS ENUM ('1','2','3','4','5','99');
CREATE TYPE "stagv2014".employment_type AS ENUM ('1','2','3','99');
CREATE TYPE "stagv2014".federal_partner_components AS ENUM 
('1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34');
CREATE TYPE "stagv2014".five_val_dk_refused AS ENUM ('0','1','8','9','99');
CREATE TYPE "stagv2014".fysb_rsn_not_providing_srvcs AS ENUM ('1','2','3','4','99');
CREATE TYPE "stagv2014".health_category AS ENUM ('27','28','29');
CREATE TYPE "stagv2014".health_status_type AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "stagv2014".house_hold_type AS ENUM ('1','3','5');
CREATE TYPE "stagv2014".housing_assmnt_exit AS ENUM ('1','2','3','4','5','6','7','8','9','10','99');
CREATE TYPE "stagv2014".homeless_atrisk_status AS ENUM ('1','2','3','4','5','6','8','9','99');

CREATE TYPE "stagv2014".incarcerated_parent_status AS ENUM ('1','2','3','99');	
CREATE TYPE "stagv2014".issues_number_of_years AS ENUM ('1','2','3');
CREATE TYPE "stagv2014".last_grade_completed  AS ENUM ('1','2','3','4','5','6','7','10','8','9','99');
CREATE TYPE "stagv2014".military_branch AS ENUM ('1','2','3','4','6','8','9','99');
CREATE TYPE "stagv2014".months_homeless_past_3_years AS ENUM ('100','7','8','9','99');
CREATE TYPE "stagv2014".no_adap_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "stagv2014".no_health_insurance_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "stagv2014".no_medical_assistance_reason AS ENUM (	
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "stagv2014".not_employed_reason  AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "stagv2014".no_yes  AS ENUM (	
'0',
'1',
'99');
CREATE TYPE "stagv2014".no_yes_refused AS ENUM (
'0',
'1',
'9',
'99');
CREATE TYPE "stagv2014".path_how_confirmed AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "stagv2014".path_smi_info_how_confirmed AS ENUM (	
'0',
'1',
'2',
'3',
'8',
'9',
'99');
CREATE TYPE "stagv2014".percentage_ami AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "stagv2014".project_completion_status AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "stagv2014".project_type AS ENUM (
'1',
'2',
'3',
'4',
'6',
'7',
'8',
'9',
'10',
'11',
'12',
'13',
'14');
CREATE TYPE "stagv2014".reason_not_enrolled AS ENUM (	
'1',
'2',
'99');
CREATE TYPE "stagv2014".record_type AS ENUM (	
'12',
'14',
'15',
'16',
'141',
'142',
'143',
'144',
'151',
'152',
'161',
'162',
'200');

CREATE TYPE "stagv2014".referral_outcome AS ENUM (	
'1',
'2',
'3');
CREATE TYPE "stagv2014".referral_source AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'10',
'11',
'12',
'13',
'14',
'15',
'16',
'17',
'18',
'19',
'20',
'21',
'22',
'23',
'24',
'25',
'26',
'27',
'28',
'29',
'30',
'31',
'32',
'33',
'34',
'35',
'36',
'37',
'38',
'39',
'8',
'9',
'99');

CREATE TYPE "stagv2014".relationship_to_head_of_household AS ENUM (
'1',
'2',
'3',
'4',
'5');
CREATE TYPE "stagv2014".residence_prior  AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'8',
'9',
'12',
'13',
'14',
'15',
'16',
'17',
'18',
'19',
'20',
'21',
'22',
'23',
'24',
'25',
'26',
'99');

CREATE TYPE "stagv2014".residence_prior_length_of_stay AS ENUM (	
'2',
'3',
'4',
'5',
'8',
'9',
'10',
'11',
'99');
CREATE TYPE "stagv2014".school_status AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'8',
'9',
'99');
CREATE TYPE "stagv2014".sexual_orientation AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'8',
'9',
'99');
CREATE TYPE "stagv2014".subsidy_information  AS ENUM (
'1',
'2',
'3',
'4');
CREATE TYPE "stagv2014".target_population_type  AS ENUM ( 	
'1',
'3',
'4');

CREATE TYPE "stagv2014".times_homeless_past_3_years  AS ENUM (
'0',
'1',
'2',
'3',
'4',
'8',
'9',
'99');

CREATE TYPE "stagv2014".tracking_method  AS ENUM ( 	
'0',
'3');
CREATE TYPE "stagv2014".when_dom_violence_occurred AS ENUM (
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "stagv2014".youth_age_group  AS ENUM (	
'1',
'2',
'3');

CREATE TYPE "stagv2014".housing_status AS ENUM (
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'8',
'9',
'99');

CREATE TYPE "stagv2014".state AS ENUM (
'AK',
'AL',
'AR',
'AZ',
'CA',
'CO',
'CT',
'DE',
'FL',
'GA',
'HI',
'IA',
'ID',
'IL',
'IN',
'KS',
'KY',
'LA',
'MA',
'MD',
'ME',
'MI',
'MN',
'MO',
'MS',
'MT',
'NC',
'ND',
'NE',
'NH',
'NJ',
'NM',
'NV',
'NY',
'OH',
'OK',
'OR',
'PA',
'RI',
'SC',
'SD',
'TN',
'TX',
'UT',
'VA',
'VT',
'WA',
'WI',
'WV',
'WY',
'DC',
'AS',
'FM',
'GU',
'MH',
'MP',
'PR',
'PW',
'VI',
'AA',
'AE',
'AP');

-- DROP TABLE "stagv2014"."base_metadata";


 
CREATE TABLE "stagv2014".hmis_type
(
  "id" serial NOT NULL ,
  "name" character(50) NOT NULL,
  "value" character(50) NOT NULL,
  "description" text,
  "year" bigint,
  "status" character(10),
  "expiration_date" timestamp,
  "date_created" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  CONSTRAINT hmis_type_pk PRIMARY KEY ("id")
)
WITH (
  OIDS=FALSE
);

INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('address_data_quality','1','Full address reported','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('address_data_quality','2','Incomplete or estimated address reported','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('address_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('address_data_quality','9','Client refused','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('address_data_quality','99','Data not collected','ACTIVE');

INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','0','No','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','1','Yes','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','8','Client doesn''t know','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','9','Client refused','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','99','Data not collected','ACTIVE');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','1',  'Referred to emergency shelter/safe haven');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','2', 'Referred to transitional housing');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','3', 'Referred to rapid re-housing');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','4', 'Referred to permanent supportive housing');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','5', 'Referred to homelessness prevention');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','6', 'Referred to street outreach');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','7', 'Referred to other continuum project type');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','8', 'Referred to a homelessness diversion program');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','9', 'Unable to refer/accept within continuum; ineligible for continuum projects');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','10','Unable to refer/accept within continuum; continuum services unavailable');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','11','Referred to other community project (non-continuum)');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','12','Applicant declined referral/acceptance');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','13','Applicant terminated assessment prior to completion');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','14','Other/specify');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','1','Year-round');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','2','Seasonal');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','3','Overflow');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','1','Facility-based');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','2','Voucher');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','3','Other');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','1','1-3');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','2','4-7');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','3','8-30');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','4','More than 30');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('countofexchangeforsex','8','Client doesn''t know','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('countofexchangeforsex','9','Client refused','ACTIVE');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','5','Physical Disability');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','6','Developmental Disability');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','7','Chronic Health Condition');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','8','HIV/AIDS');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','9','Mental Health Problem');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','10','Substance Abuse');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','1','Honorable');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','2','General under honorable conditions');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','4','Bad conduct');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','5','Dishonorable');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','6','Under other than honorable conditions (OTH)');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','7','Uncharacterized');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('discharge_status','8','Client doesn''t know','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('discharge_status','9','Client refused','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('discharge_status','99','Data not collected','ACTIVE');

INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('dob_data_quality','1','Full DOB reported','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('dob_data_quality','2','Approximate or partial DOB reported','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('dob_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('dob_data_quality','9','Client refused','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('dob_data_quality','99','Data not collected','ACTIVE');


INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','1','Left for other opportunities – Independent living');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','2','Left for other opportunities - Education');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','3','Left for other opportunities - Military');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','4','Left for other opportunities - Other');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','5','Needs could not be met by project');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','99','Data not collected');

 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','1','Full-time');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','2','Part-time');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','3','Seasonal / sporadic (including day labor)');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','99','Data not collected');
 
 INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('ethnicity','0','Non-Hispanic/Non-Latino','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('ethnicity','1','Hispanic/Latino','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status) values    ('ethnicity','8','Client does not know','ACTIVE');
 INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values  ('ethnicity','9','Client refused','ACTIVE');
 INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values ('ethnicity','99','Data not collected','ACTIVE');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','24','Deceased');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','15','Foster care home or foster care group home');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','6','Hospital or other residential non-psychiatric medical facility');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','7','Jail, prison or juvenile detention facility');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','25','Long-term care facility or nursing home');	
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','26','Moved from one HOPWA funded project to HOPWA PH ');   
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','27','Moved from one HOPWA funded project to HOPWA TH');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','11','Owned by client, no ongoing housing subsidy');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','21','Owned by client, with ongoing housing subsidy');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','3','Permanent housing for formerly homeless persons (such as: CoC project; or HUD legacy programs; or HOPWA PH)');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','16','Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','4','Psychiatric hospital or other psychiatric facility');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','10','Rental by client, no ongoing housing subsidy');	
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','19','Rental by client, with VASH housing subsidy');  
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','28','Rental by client, with GPD TIP housing subsidy');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','29','Residential project or halfway house with no homeless criteria');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','18','Safe Haven');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','22','Staying or living with family, permanent tenure');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','12','Staying or living with family, temporary tenure (e.g., room, apartment or house)');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','23','Staying or living with friends, permanent tenure');	
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','13','Staying or living with friends, temporary tenure (e.g., room apartment or house)');  
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','5','Substance abuse treatment facility or detox center ');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','2','Transitional housing for homeless persons (including homeless youth)');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','17','Other');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('destination','ACTIVE','30','No exit interview completed');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('destination','8','Client doesn''t know','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('destination','9','Client refused','ACTIVE');   											    
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('destination','99','Data not collected','ACTIVE'); 

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','1','HUD:CoC – Homelessness Prevention (High Performing Comm. Only)'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','2','HUD:CoC – Permanent Supportive Housing');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','3','HUD:CoC – Rapid Re-Housing');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','4','HUD:CoC – Supportive Services Only');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','5','HUD:CoC – Transitional Housing');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','6','HUD:CoC – Safe Haven');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','7','HUD:CoC – Single Room Occupancy (SRO)');   
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','8','HUD:ESG – Emergency Shelter (operating and/or essential services)');  
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','9','HUD:ESG – Homelessness Prevention'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','10','HUD:ESG – Rapid Rehousing');  
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','11','HUD:ESG – Street Outreach');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','12','HUD:Rural Housing Stability Assistance Program');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','13','HUD:HOPWA – Hotel/Motel Vouchers');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','14','HUD:HOPWA – Housing Information');  
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','15','HUD:HOPWA – Permanent Housing (facility based or TBRA)');  
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','16','HUD:HOPWA – Permanent Housing Placement');  
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','17','HUD:HOPWA – Short-Term Rent, Mortgage, Utility assistance'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','18','HUD:HOPWA – Short-Term Supportive Facility');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','19','HUD:HOPWA – Transitional Housing (facility based or TBRA)'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','20','HUD:HUD/VASH');  
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','21','HHS:PATH – Street Outreach and Supportive Services Only');   
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','22','HHS:RHY – Basic Center Program (prevention and shelter)');   
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','23','HHS:RHY – Maternity Group Home for Pregnant and Parenting Youth');   
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','24','HHS:RHY – Transitional Living Program');  
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','25','HHS:RHY – Street Outreach Project');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','26','HHS:RHY – Demonstration Project');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','27','VA: Community Contract Emergency Housing');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','28','VA: Community Contract Residential Treatment Program');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','29','VA:Domiciliary Care');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','30','VA:Community Contract Safe Haven Program');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','31','VA:Grant and Per Diem Program');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','32','VA:Compensated Work Therapy Transitional Residence');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','33','VA:Supportive Services for Veteran Families');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('funder','ACTIVE','34','N/A');

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','1','Out of age range');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','2','Ward of the State – Immediate Reunification');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','3','Ward of the Criminal Justice System – Immediate Reunification');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','4','Other');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('reason_no_services','99','Data not collected','ACTIVE'); 
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('gender','1','Male','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('gender','2','Transgender male to female','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('gender','3','Transgender female to male','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('gender','4','Other','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('gender','8','Client does not know','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('gender','9','Client refused','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('gender','99','Data not collected','ACTIVE');
 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_category','ACTIVE','27','General Health Status');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_category','ACTIVE','28','Dental Health Status');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_category','ACTIVE','29','Mental Health Status');
  
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_status','ACTIVE','1','Excellent');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_status','ACTIVE','2','Very good');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_status','ACTIVE','3','Good');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_status','ACTIVE','4','Fair'); 
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('health_status','ACTIVE','5','Poor');	
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('health_status','8','Client does not know','ACTIVE');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('health_status','9','Client refused','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('health_status','99','Data not collected','ACTIVE');	
	
	
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','1','Households without children'); 
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','3','Households with at least one adult and one child'); 
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','4','Households with only children');

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','1','Able to maintain the housing they had at project entry');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','2','Moved to new housing unit');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','3','Moved in with family/friends on a temporary basis');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','4','Moved in with family/friends on a permanent basis ');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','5','Moved to a transitional or temporary housing facility or program');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','6','Client became homeless – moving to a shelter or other place unfit for human habitation');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','7','Client went to jail/prison');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','10','Client died ');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('housingassessment','8','Client does not know','ACTIVE');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('housingassessment','9','Client refused','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('housingassessment','99','Data not collected','ACTIVE');	

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','1','One parent / legal guardian is incarcerated');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','2','One parent / legal guardian is incarcerated');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','3','The only parent / legal guardian is incarcerated');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('incarceratedparentstatus','99','Data not collected','ACTIVE');	

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','1','Less than one year');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','2','1 to 2 years');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','3','3 to 5 or more years');

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','1','Less than one year');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','2','1 to 2 years');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','3','3 to 5 or more years');

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','1','Less than Grade 5');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','2','Grades 5-6');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','3','Grades 7-8');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','4','Grades 9-11');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','5','rade 12');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','6','School program does not have grade levels');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','7','GED');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('lastgradecompleted','ACTIVE','10','Some college');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('lastgradecompleted','8','Client does not know','ACTIVE');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('lastgradecompleted','9','Client refused','ACTIVE');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('lastgradecompleted','99','Data not collected','ACTIVE');	
 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','1','Army');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','2','Air Force');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','3','Navy'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','4','Marines'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','6','Coast Guard');
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('military_branch','8','Client does not know','ACTIVE');
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('military_branch','9','Client refused','ACTIVE');
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('military_branch','99','Data not collected','ACTIVE');
  
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','100','0 to 12 months (with a leading 1)');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','7','More than 12 months');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','8','Client does not know','ACTIVE');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','9','Client refused','ACTIVE');
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','99','Data not collected','ACTIVE');
  
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','1','Full name reported'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','2','Partial, street name, or code name reported');  
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('name_data_quality','8','Client does not know','ACTIVE');  
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('name_data_quality','9','Client refused','ACTIVE');  
    INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('name_data_quality','99','Data not collected','ACTIVE');  
    
      INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','1','Applied; decision pending');
      INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','2','Applied; client not eligible');
      INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','3','Client did not apply');
      INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','4','Insurance type N/A for this client');
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noadapreason','8','Client does not know','ACTIVE');  
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noadapreason','9','Client refused','ACTIVE');  
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noadapreason','99','Data not collected','ACTIVE');  
    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nocobrareason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nocobrareason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nocobrareason','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nomedicaidreason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nomedicaidreason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nomedicaidreason','99','Data not collected','ACTIVE');  

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','1','Applied; decision pending');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','2','Applied; client not eligible');    
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','3','Client did not apply');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','4','Insurance type N/A for this client');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nomedicarereason','8','Client does not know','ACTIVE'); 
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nomedicarereason','9','Client refused','ACTIVE');  
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nomedicarereason','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noprivatepayreason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noprivatepayreason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noprivatepayreason','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noschipreason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noschipreason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('noschipreason','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','99','Data not collected','ACTIVE');  


INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('novamedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('novamedreason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('novamedreason','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','1','Applied; decision pending');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','2','Applied; client not eligible');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','3','Client did not apply');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','1','Looking for work');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','2','Unable to work');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','3','Not looking for work');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('not_employed_reason','99','Data not collected','ACTIVE');  

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','1','Unconfirmed; presumptive or self-report');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','2','Confirmed through assessment and clinical evaluation'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','3','Confirmed by prior evaluation or clinical records');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('pathhowconfirmed','99','Data not collected','ACTIVE');   

INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','0','No');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','1','Unconfirmed; presumptive or self-report');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','2','Confirmed through assessment and clinical evaluation'); 
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','3','Confirmed by prior evaluation or clinical records');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('pathsmiinformation','8','Client does not know','ACTIVE'); 
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('pathsmiinformation','9','Client refused','ACTIVE');  
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('pathsmiinformation','99','Data not collected','ACTIVE');  
 
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','1','Completed project');
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','2','Youth voluntarily left early'); 
INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','3','Youth was expelled or otherwise involuntarily discharged from project');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('projectcompletionstatus','99','Data not collected','ACTIVE');  

INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','1','American Indian or Alaska Native','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','2','Asian','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','3','Black or African American','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','4','Native Hawaiian or Other Pacific Islander','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','5','White','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','8','Client does not know','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','9','Client refused','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('race','99','Data not collected','ACTIVE');	

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','1','Emergency Shelter'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','2','Transitional Housing'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','3','PH - Permanent Supportive Housing (disability required for entry)');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','4','Street Outreach'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','6','Services Only');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','7','Other'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','8','Safe Haven'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','9','PH – Housing Only');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','10','PH – Housing with Services (no disability required for entry)');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','11','Day Shelter');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Homelessness Prevention'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','13','PH - Rapid Re-Housing');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Coordinated Assessment');
 

 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','1','Client was found ineligible for PATH');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','2','Client was not enrolled for other reason(s)');
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('reason_not_enrolled','99','Data not collected','ACTIVE'); 


 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Contact');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Services Provided');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','15','Financial Assistance');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','16','Referrals Provided');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','141','PATH service');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','142','RHY service');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','143','HOPWA service');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','144','SSVF service');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','151','HOPWA financial assistance');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','152','SSVF financial assistance');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','161','PATH referral');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','162','RHY referral');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','200','Bed night');
  
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','1','Attained');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','2','Not Attained');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','3','Unkown');
 
 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','1','Self-Referral');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','2','Individual: Parent/Guardian');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','3','Individual: Relative or Friend');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','4','Individual: Other Adult or Youth'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','5','Individual: Partner/Spouse');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','6','Individual: Foster Parent');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','7','Outreach Project: FYSB');  	
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','10','Outreach Project: Other');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','11','Temporary Shelter: FYSB Basic Center Project');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','12','Temporary Shelter: Other Youth Only Emergency Shelter');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','13','Temporary Shelter: Emergency Shelter for Families');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','14','Temporary Shelter: Emergency Shelter for Individuals');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','15','Temporary Shelter: Domestic Violence Shelter');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','16','Temporary Shelter: Safe Place');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','17','Temporary Shelter: Other');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','18','Residential Project: FYSB Transitional Living Project'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','19','Residential Project: Other Transitional Living Project');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','20','Residential Project: Group Home'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','21','Residential Project: Independent Living Project'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','22','Residential Project: Job Corps'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','23','Residential Project: Drug Treatment Center');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','24','Residential Project: Treatment Center');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','25','Residential Project: Educational Institute'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','26','Residential Project: Other Agency project'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','27','Residential Project: Other Project'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','28','Hotline: National Runaway Switchboard'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','29','Hotline: Other'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','30','Other Agency: Child Welfare/CPS'); 
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','31','Other Agency: Non-Residential Independent Living Project');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','32','Other Project Operated by your Agency');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','33','Other Youth Services Agency');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','34','Juvenile Justice');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','35','Law Enforcement/ Police');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','36','Religious Organization');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','37','Mental Hospital');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','38','School');
 INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','39','Other Organization');
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('referralsource','8','Client does not know','ACTIVE'); 
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('referralsource','9','Client refused','ACTIVE');  
 INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('referralsource','99','Data not collected','ACTIVE');  
 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','1','Self (head of household)'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','2','Head of household’s child'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','3','Head of household’s spouse or partner');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','4','Head of household’s other relation member (other relation to head of household)');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','5','Other: non-relation member');
  
  
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','2','Transitional housing for homeless persons (including homeless youth)');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','3','Permanent housing for formerly homeless persons (such as: CoC project; HUD legacy programs; or HOPWA PH)'); 
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','4','Psychiatric hospital or other psychiatric facility');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','5','Substance abuse treatment facility or detox center');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','6','Hospital or other residential non-psychiatric medical facility');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','7','Jail, prison or juvenile detention facility'); 
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','8','Client does not know');
   INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','9','Client refused'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','12','Staying or living in a family member’s room, apartment or house');          
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','13','Staying or living in a friend’s room, apartment or house');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','15','Foster care home or foster care group home');                         
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','16','Place not meant for habitation (e.g. a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','17','Other');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','18','Safe Haven');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','19','Rental by client, with VASH subsidy');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','21','Owned by client, with ongoing housing subsidy'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','22','Rental by client, no ongoing housing subsidy');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','23','Owned by client, no ongoing housing subsidy'); 
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','24','Long-term care facility or nursing home');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','25','Rental by client, with GPD TIP subsidy');
  INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','26','Residential project or halfway house with no homeless criteria');
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('referralsource','99','Data not collected','ACTIVE');
  
  
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','2','More than one week, but less than one month'); 
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','3','One to three months'); 
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','4','More than three months, but less than one year');  
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','5','One year or longer'); 
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','8','Client doesn''t know'); 
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','9','Client refused');
    INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','10','One day or less');
    INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','11','Two days to one week'); 
   INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('residencePriorlengthofstay','99','Data not collected','ACTIVE'); 
  
  
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('sexualorientation','ACTIVE','1','Heterosexual');
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('sexualorientation','ACTIVE','2','Gay');
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('sexualorientation','ACTIVE','3','Lesbian');
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('sexualorientation','ACTIVE','4','Bisexual');
     INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('sexualorientation','ACTIVE','5','Questioning / Unsure'); 
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('sexualorientation','8','Client does not know','ACTIVE'); 
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('sexualorientation','9','Client refused','ACTIVE');  
  INSERT INTO "stagv2014".hmis_type (name,value,description,status)  values ('sexualorientation','99','Data not collected','ACTIVE');  	

 
          
        INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('ssndataquality','1','Full SSN reported','ACTIVE');
        INSERT INTO "stagv2014".hmis_type (name,value,description,status) values   ('ssndataquality','2','Approximate or partial SSN reported','ACTIVE');
        INSERT INTO "stagv2014".hmis_type (name,value,description,status) values    ('ssndataquality','8','Client does not know','ACTIVE');
        INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values  ('ssndataquality','9','Client refused','ACTIVE');
        INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values ('ssndataquality','99','Data not collected','ACTIVE');
        
        
        INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','1','Without a subsidy');
        INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','2','With the subsidy they had at project entry');
   	INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','3','With an on-going subsidy acquired since project entry');
   	INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','4','Only with financial assistance other than a subsidy'); 
   	
   	INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','1','DV Domestic Violence victims');
   	INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','3','HIV Persons with HIV/AIDS');
   	INSERT INTO "stagv2014".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','4','NA Not Applicable');
   	
	
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','0','0 (not homeless - Prevention only)','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','1','1 (homeless only this time)','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','2','2','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','3','3','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','4','4 or more','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values  ('timesHomelesspastthreeyears','8','Client does not know','ACTIVE');
	INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values  ('timesHomelesspastthreeyears','9','Client refused','ACTIVE');
	INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values ('timesHomelesspastthreeyears','99','Data not collected','ACTIVE');
		       
	
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('trackingmethod','0','Entry/Exit Date','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('trackingmethod','3','Night-by-Night','ACTIVE');
	
	
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('whenoccurred','1','Within the past three months','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('whenoccurred','2','Three to six months ago (excluding six months exactly)','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('whenoccurred','3','Six months to one year ago (excluding one year exactly)','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('whenoccurred','4','One year ago or more','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values  ('whenoccurred','8','Client does not know','ACTIVE');
	INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values  ('whenoccurred','9','Client refused','ACTIVE');
	INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values ('whenoccurred','99','Data not collected','ACTIVE');
	
	
	
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('housingstatus','1','Category 1 - Homeless','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('housingstatus','2','Category 2 - At imminent risk of losing housing','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('housingstatus','3','At-risk of homelessness','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('housingstatus','4','Stably Housed','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('housingstatus','5','Category 3 - Homeless only under other federal statutes','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('housingstatus','6','Category 4 - Fleeing domestic violence','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values  ('housingstatus','8','Client does not know','ACTIVE');
	INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values  ('housingstatus','9','Client refused','ACTIVE');
	INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values ('housingstatus','99','Data not collected','ACTIVE');
	
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('youth_age_group','1','Only under age 18','ACTIVE');
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('youth_age_group','2','Only ages 18 to 24','ACTIVE'); 
	INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('youth_age_group','3','Only youth under age 24 (both of the above)','ACTIVE');
	
	
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('veteran_status','0','No','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('veteran_status','1','Yes','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values    ('veteran_status','8','Client does not know','ACTIVE');
INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values  ('veteran_status','9','Client refused','ACTIVE');
INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values ('veteran_status','99','Data not collected','ACTIVE');

INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('afghanistan_oef','0','No','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values ('afghanistan_oef','1','Yes','ACTIVE');
INSERT INTO "stagv2014".hmis_type (name,value,description,status) values    ('afghanistan_oef','8','Client does not know','ACTIVE');
INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values  ('afghanistan_oef','9','Client refused','ACTIVE');
INSERT INTO "stagv2014".hmis_type  (name,value,description,status) values ('afghanistan_oef','99','Data not collected','ACTIVE');

create table "stagv2014".source
(
  id uuid not null,
  export text,
  softwarevendor character varying(50),
  softwareVersion character varying(50),
  sourceContactEmail	text,
  sourceContactExtension	text,
  sourceContactFirst	character varying(50),
  sourceContactLast	character varying(50),
  sourceContactPhone	character varying(12),
  sourceID	text,
  sourceName	character varying(50),
 "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
  constraint "source_pkey" primary key (id)
     )
with (
  oids=false
);

create table "stagv2014".export
(
  id uuid not null,
  export_date  timestamp,
  start_date  timestamp,
  end_date  timestamp,
  exportPeriodType text,
  exportDirective text,
  source_id uuid,
"project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
  constraint "export_pkey" primary key (id),
      CONSTRAINT source_fkey FOREIGN KEY (source_id)
      REFERENCES stagv2014.source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);

-- DROP TABLE "stagv2014"."client";
CREATE TABLE "stagv2014".client
(
  "id" uuid NOT NULL,
  "dedup_client_id" uuid,
  "first_name" character(50),
  "middle_name" character(50),
  "last_name" character(50),
  "name_suffix" character(50),
  "name_data_quality" "stagv2014".name_data_quality,
   "ssn" character(9),
  "ssn_data_quality" "stagv2014".ssn_data_quality,
  "dob" timestamp,
  "dob_data_quality" "stagv2014".dob_data_quality,
  "gender" "stagv2014".gender,
  "other_gender" character(10),
  "ethnicity" "stagv2014".ethnicity,
  "race"  "stagv2014".race,
  "veteran_status" "stagv2014".veteran_status,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT client_pk PRIMARY KEY ("id")
      )
WITH (
  OIDS=FALSE
);
-- Table: "stagv2014"."client"


CREATE TABLE "stagv2014".veteran_info
(
  "id" uuid NOT NULL,
  "year_entrd_service" integer,
  "year_seperated" integer,
  "world_war_2" "stagv2014".five_val_dk_refused,
  "korean_war" "stagv2014".five_val_dk_refused,
  "vietnam_war" "stagv2014".five_val_dk_refused,
  "desert_storm" "stagv2014".five_val_dk_refused,
  "afghanistan_oef" "stagv2014".afghanistanoef,
  "iraq_oif" "stagv2014".five_val_dk_refused,
  "iraq_ond" "stagv2014".five_val_dk_refused,
  "other_theater" "stagv2014".five_val_dk_refused,
  "military_branch" "stagv2014".military_branch,
  "discharge_status" "stagv2014".discharge_status,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  "client_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT veteran_info_pk PRIMARY KEY ("id"),
  CONSTRAINT veteran_info_client_fk FOREIGN KEY ("client_id")
      REFERENCES "stagv2014".client ("id")
      )
WITH (
  OIDS=FALSE
);

CREATE TABLE "stagv2014".enrollment
(
  id uuid NOT NULL,
 continuouslyHomelessOneYear "stagv2014".youth_age_group,
disablingCondition "stagv2014".five_val_dk_refused,
entrydate timestamp,
householdid uuid,
housingstatus "stagv2014".housing_status,
monthsHomelessPastThreeYears "stagv2014".months_homeless_past_3_years,
monthsHomelessThisTime "stagv2014".times_homeless_past_3_years,
otherresidenceprior character varying(50),
personalid uuid,
projectentryid uuid,
projectid uuid,
relationshiptohoh "stagv2014".relationship_to_head_of_household,
residencePrior "stagv2014".residence_prior,
residencePriorlengthofstay "stagv2014".residence_prior_length_of_stay,
statusDocumented "stagv2014".no_yes,
timesHomelesspastthreeyears "stagv2014".times_homeless_past_3_years,
yearshomeless integer,
client_id uuid,
project_group_code character varying(8),
date_created timestamp,
date_updated timestamp,
 "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
user_id uuid,
export_id uuid,
parent_id uuid,
version integer,
deleted boolean DEFAULT false,
sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "enrollment_pkey" PRIMARY KEY (id),
    CONSTRAINT enrollment_client_fk FOREIGN KEY ("client_id")
      REFERENCES "stagv2014".client ("id")
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "stagv2014".path_status
(
  "id" uuid NOT NULL,
  "date_of_status" timestamp,
  "client_enrolled_in_path" bigint,
  "reason_not_enrolled"  "stagv2014".reason_not_enrolled,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT path_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_path_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE "stagv2014".rhybcp_status
(
  "id" uuid NOT NULL,
  "status_date" timestamp,
  "fysb_youth" "stagv2014".no_yes,
  "reason_no_services" "stagv2014".fysb_rsn_not_providing_srvcs,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT rhybcp_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_rhybcp_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: stagv2014.last_perm_address



CREATE TABLE "stagv2014".last_perm_address
(
  "id" uuid NOT NULL,
  "street" text,
  "city" text,
  "state" "stagv2014".state,
  "zip" character(10),
  "address_data_quality" "stagv2014".address_data_quality,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT last_perm_address_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_last_perm_address_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: stagv2014.percent_ami



CREATE TABLE "stagv2014".percent_ami
(
 "id" uuid NOT NULL,
  "percentage" integer,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT percent_ami_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_percent_ami_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: stagv2014.last_grade_completed

CREATE TABLE "stagv2014".schoolstatus
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "school_status" "stagv2014".school_status,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT school_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_schoolstatus_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "stagv2014".employment
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "employed" "stagv2014".five_val_dk_refused,
  "employment_type" "stagv2014".employment_type,
  "not_employed_reason" "stagv2014".not_employed_reason,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT employment_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_coc_employment_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "stagv2014".health_status
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  "information_date" timestamp,
  "health_category" "stagv2014".health_category,
  "health_status" "stagv2014".health_status_type,
  "due_date" timestamp,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT health_status_pk PRIMARY KEY ("id"),
     CONSTRAINT "enrollment_health_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

create table "stagv2014".organization
(
  organizationcommonname text,
  id uuid not null,
  organizationname text,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
version integer,
deleted boolean DEFAULT false,
sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "organization_pkey" primary key (id)
)
with (
  oids=false
);


CREATE TABLE  "stagv2014".project
(
  id uuid NOT NULL,
  enrollmentid uuid,
  continuumproject "stagv2014".no_yes,
  organizationid uuid,
  projectcommonname text,
  projectname text,
  projecttype "stagv2014".project_type,
  residentialaffiliation "stagv2014".no_yes,
  targetpopulation "stagv2014".target_population_type,
  trackingmethod "stagv2014".tracking_method,
  project_group_code character varying(8),
  date_created timestamp,
  date_updated timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  user_id uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "project_pk" PRIMARY KEY (id),
       CONSTRAINT "enrollment_project_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
        CONSTRAINT "organization_project_fkey" FOREIGN KEY (organizationid)
      REFERENCES stagv2014.organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- Table: "affiliation"

-- DROP TABLE "affiliation";

CREATE TABLE "stagv2014".affiliation
(
  id uuid NOT NULL,
  projectid uuid,
  resprojectid text,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "affiliation_pkey" PRIMARY KEY (id),
  CONSTRAINT "affiliation_project_fkey" FOREIGN KEY (projectid)
      REFERENCES stagv2014.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE "stagv2014".bedinventory
(
  id uuid NOT NULL,
  bed_inventory integer,
  ch_bed_inventory integer,
  vet_bed_inventory integer,
  youth_age_group "stagv2014".youth_age_group,
  youth_bed_inventory bigint,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "bedinventory_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

-- table: "projectcoc"

-- drop table "projectcoc";

create table "stagv2014".projectcoc
(
  id uuid not null,
  coccode text,
  projectid uuid,
  "project_group_code" character varying(8),
   date_created timestamp,
   date_updated timestamp,
    "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
   user_id uuid,
   export_id uuid,
   parent_id uuid,
   version integer,
   deleted boolean DEFAULT false,
   sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "projectcoc_pkey" primary key (id),
  constraint "projectcoc_projectid_fkey" foreign key (projectid)
      references stagv2014.project (id) match simple
)
with (
  oids=false
);
CREATE TABLE "stagv2014".enrollment_coc
(
  id uuid NOT NULL,
  project_co_id uuid,
  enrollmentid uuid,
  coc_code character(20),
  project_group_code character varying(8),
  date_created timestamp,
  date_updated timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  user_id uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT "enrollment_coc_pkey" PRIMARY KEY ("id"),
  CONSTRAINT "enrollment_coc_project_co_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES stagv2014.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT "project_coc_enrollment_coc_fkey" FOREIGN KEY ("project_co_id")
      REFERENCES stagv2014.projectcoc ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


create table "stagv2014".site
(
id uuid not null,
address character varying(100),
city  character varying(50),
geocode  integer, 
principal_site "stagv2014".no_yes,
project_coc_id uuid,
state "stagv2014".state, 
zip text,
"project_group_code" character varying(8),
date_created timestamp,
date_updated timestamp,
 "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
user_id uuid,
export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
constraint "site_pkey" primary key (id),
  constraint "site_projectcoc_fkey" foreign key (project_coc_id)
      references stagv2014."projectcoc" (id) match simple
      on update no action on delete no action
)
with (
  oids=false
);



create table "stagv2014".inventory
(
   id uuid not null,
  availabilty "stagv2014".availability,
  bedinventory uuid,
  bedtype "stagv2014".bed_type,
  hmisparticipatingbeds integer,
  householdtype "stagv2014".house_hold_type,
  inventoryenddate timestamp,
  inventorystartdate timestamp,
  project_coc_id uuid,
  unitinventory integer,
  "project_group_code" character varying(8),
  date_created timestamp,
  date_updated timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  user_id uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "inventory_pkey" primary key (id),
  constraint "inventory_projectcocid_fkey" foreign key (project_coc_id)
      references stagv2014."projectcoc" (id) match simple
      on update no action on delete no action,
      CONSTRAINT "bed_inventory_fkey" FOREIGN KEY (bedinventory)
      REFERENCES stagv2014.bedinventory (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "funder"

-- drop table "funder";

create table  "stagv2014".funder
(
"id"  uuid not null,
  "enddate" timestamp,
  "funder" "stagv2014".federal_partner_components,
  "grantid" text,
  "projectid" uuid,
  "startdate" timestamp,
  "project_group_code" character varying(8),
  date_created timestamp,
  date_updated timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  user_id uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "funder_pkey" primary key ("id"),
  constraint "funder_projectid_fkey" foreign key ("projectid")
      references stagv2014.project (id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "stagv2014".rhybcpstatus
(
  id uuid not null,
  fysbyouth integer,
  enrollmentid uuid,
  reasonnoservices integer,
  statusdate timestamp,
  "project_group_code" character varying(8),
     "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "rhybcpstatus_pkey" primary key (id),
  constraint "rhybcpstatus_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "sexualorientation"

-- drop table "sexualorientation";

create table "stagv2014".sexualorientation
(
  id uuid not null,
  enrollmentid uuid,
  sexualorientation "stagv2014".sexual_orientation,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "sexualorientation_pkey" primary key (id),
  constraint "sexualorientation_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "stagv2014".formerwardjuvenilejustice
(
"id" uuid not null,
  "formerwardjuvenilejustice" "stagv2014".five_val_dk_refused,
  "juvenilejusticemonths" integer,
  "juvenilejusticeyears"  "stagv2014".issues_number_of_years,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "formerwardjuvenilejustice_pkey" primary key ("id"),
  constraint "formerwardjuvenilejustice_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);



create table "stagv2014".lastpermanentaddress
(
  id uuid not null,
  addressdataquality integer,
  lastpermanentcity character varying(50),
  lastpermanentstate "stagv2014".state,
  lastpermanentstreet character varying(100),
  lastpermanentzip text,
  enrollmentid uuid,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "lastpermanentaddress_pkey" primary key (id),
  constraint "lastpermanentaddress_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "stagv2014".percentami
(
  percentami integer,
  id uuid not null,
  enrollmentid uuid,
  "project_group_code" character varying(8),
     "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "percentami_pkey" primary key (id),
  constraint "percentami_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "medicalassistance"

-- drop table "medicalassistance";

create table "stagv2014".medicalassistance
(
  adap "stagv2014".five_val_dk_refused,
  hivaidsassistance "stagv2014".five_val_dk_refused,
  id uuid not null,
  noadapreason "stagv2014".no_adap_reason,
  nohivaidsassistancereason "stagv2014".no_medical_assistance_reason,
   enrollmentid uuid,
   "project_group_code" character varying(8),
     "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "medicalassistance_pkey" primary key (id),
  constraint "medicalassistance_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);



create table "stagv2014".youthcriticalissues
(
  abuseandneglectfam "stagv2014".no_yes,
  abuseandneglectyouth "stagv2014".no_yes,
  activemilitaryparent "stagv2014".no_yes,
  alcoholdrugabusefam "stagv2014".no_yes,
  alcoholdrugabuseyouth "stagv2014".no_yes,
  healthissuesfam "stagv2014".no_yes,
  healthissuesyouth "stagv2014".no_yes,
  householddynamics "stagv2014".no_yes,
  housingissuesfam "stagv2014".no_yes,
  housingissuesyouth "stagv2014".no_yes,
  incarceratedparent "stagv2014".no_yes,
  incarceratedparentstatus  "stagv2014".incarcerated_parent_status,
  insufficientincome "stagv2014".no_yes,
  mentaldisabilityfam "stagv2014".no_yes,
  mentaldisabilityyouth "stagv2014".no_yes,
  mentalhealthissuesfam "stagv2014".no_yes,
  mentalhealthissuesyouth "stagv2014".no_yes,
  physicaldisabilityfam "stagv2014".no_yes,
  physicaldisabilityyouth "stagv2014".no_yes,
  enrollmentid uuid,
  schooleducationalissuesfam "stagv2014".no_yes,
  schooleducationalissuesyouth "stagv2014".no_yes,
  sexualorientationgenderidfam "stagv2014".no_yes,
  sexualorientationgenderidyouth "stagv2014".no_yes,
  unemploymentfam "stagv2014".no_yes,
  unemploymentyouth "stagv2014".no_yes,
  id uuid not null,
  "project_group_code" character varying(8),
     "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "youthcriticalissues_pkey" primary key (id),
  constraint "youthcriticalissues_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "worsthousingsituation"

-- drop table "worsthousingsituation";

create table  "stagv2014".worsthousingsituation
(
  enrollmentid uuid,
  worsthousingsituation "stagv2014".five_val_dk_refused,
  id uuid not null,
  "project_group_code" character varying(8),
      "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "worsthousingsituation_pkey" primary key (id),
  constraint "worsthousingsituation_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "stagv2014".formerwardchildwelfare
(
  "childwelfaremonths" integer,
  "childwelfareyears" "stagv2014".issues_number_of_years,
  "formerwardchildwelfare" "stagv2014".five_val_dk_refused,
  "id" uuid not null,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
     "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "formerwardchildwelfare_pkey" primary key ("id"),
  constraint "formerwardchildwelfare_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


-- drop table "lastgradecompleted";

create table "stagv2014".lastgradecompleted
(
  lastgradecompleted "stagv2014".last_grade_completed,
  id uuid not null,
  enrollmentid uuid,
  "project_group_code" character varying(8),
       "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "lastgradecompleted_pkey" primary key (id),
  constraint "lastgradecompleted_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "stagv2014".referralsource
(
  countoutreachreferralapproaches integer,
  enrollmentid uuid,
  referralsource "stagv2014".referral_source,
  id uuid not null,
  "project_group_code" character varying(8),
       "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "referralsource_pkey" primary key (id),
  constraint "referralsource_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "stagv2014".commercialsexualexploitation
(
  "askedorforcedtoexchangeforsex" "stagv2014".asked_forced_exchange_sex,
  "id" uuid not null,
  "countofexchangeforsex" "stagv2014".count_of_exchange_sex,
  "exchangeforsexpastthreemonths" "stagv2014".five_val_dk_refused,
   enrollmentid uuid,
   "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
version integer,
deleted boolean DEFAULT false,
sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "commercialsexualexploitation_pkey" primary key ("id"),
  constraint "commercialsexualexploitation_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "domesticviolence"

-- drop table "domesticviolence";

create table "stagv2014".domesticviolence
(
  "id"  uuid not null,
  "domesticviolencevictim" "stagv2014".five_val_dk_refused,
  "enrollmentid" uuid,
  "whenoccurred" "stagv2014".when_dom_violence_occurred,
  "project_group_code" character varying(8),
       "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "domesticviolence_pkey" primary key ("id"),
  constraint "domesticviolence_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "disabilities"

-- drop table "disabilities";

create table "stagv2014".disabilities
(
  "id" uuid not null,
  "disabilityresponse" integer,
  "disabilitytype" "stagv2014".disability_type,
  "documentationonfile" "stagv2014".no_yes,
  "indefiniteandimpairs" "stagv2014".five_val_dk_refused,
  "pathhowconfirmed" "stagv2014".path_how_confirmed,
  "pathsmiinformation" "stagv2014".path_smi_info_how_confirmed,
   "enrollmentid" uuid,
  "receivingservices" "stagv2014".five_val_dk_refused,
  "project_group_code" character varying(8),
         "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "disabilities_pkey" primary key ("id"),
  constraint "disabilities_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);
-- table: "residentialmoveindate"

-- drop table "residentialmoveindate";

create table  "stagv2014".residentialmoveindate
(
  inpermanenthousing "stagv2014".no_yes,
  enrollmentid uuid,
  residentialmoveindate timestamp,
  id uuid not null,      
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "residentialmoveindate_pkey" primary key (id),
  constraint "residentialmoveindate_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
)
with (
  oids=false
);

-- table: "dateofengagement"

-- drop table "dateofengagement";

create table  "stagv2014".dateofengagement
(
  "dateofengagement" timestamp,
  "id" uuid not null,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
           "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "dateofengagement_pkey" primary key ("id"),
  constraint "dateofengagement_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "stagv2014".services
(
  dateprovided timestamp,
  faamount numeric(15,3),
  othertypeprovided character varying(50),
  enrollmentid uuid,
  recordtype "stagv2014".record_type,
  referraloutcome "stagv2014".referral_outcome,
  id uuid not null,
  subtypeprovided integer,
  typeprovided integer,
  "project_group_code" character varying(8),
           "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "services_pkey" primary key (id),
  constraint "services_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


-- drop table "incomeandsources";

create table "stagv2014".incomeandsources
(
  alimony "stagv2014".no_yes,
  alimonyamount numeric(15,3),
  childsupport "stagv2014".no_yes,
  childsupportamount numeric(15,3),
  earned "stagv2014".no_yes,
  earnedamount numeric(15,3),
  ga "stagv2014".no_yes,
  gaamount numeric(15,3),
  id uuid not null,
  incomefromanysource "stagv2014".five_val_dk_refused,
  othersource "stagv2014".no_yes,
  othersourceamount numeric(15,3),
  othersourceidentify text,
  pension "stagv2014".no_yes,
  pensionamount numeric(15,3),
  privatedisability "stagv2014".no_yes,
  privatedisabilityamount numeric(15,3),
  enrollmentid uuid,
  socsecretirement "stagv2014".no_yes,
  socsecretirementamount numeric(15,3),
  ssdi "stagv2014".no_yes,
  ssdiamount numeric(15,3),
  ssi "stagv2014".no_yes,
  ssiamount numeric(15,3),
  tanf "stagv2014".no_yes,
  tanfamount numeric(15,3),
  totalmonthlyincome numeric(15,3),
  unemployment "stagv2014".no_yes,
  unemploymentamount numeric(15,3),
  vadisabilitynonservice "stagv2014".no_yes,
  vadisabilitynonserviceamount numeric(15,3),
  vadisabilityservice "stagv2014".no_yes,
  vadisabilityserviceamount numeric(15,3),
  workerscomp "stagv2014".no_yes,
  workerscompamount numeric(15,3),
  "project_group_code" character varying(8),
           "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false, 
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "incomeandsources_pkey" primary key (id),
  constraint "incomeandsources_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);



-- drop table "noncashbenefits";

create table "stagv2014".noncashbenefits
(
  benefitsfromanysource "stagv2014".five_val_dk_refused,
  id uuid not null,
  othersource "stagv2014".no_yes,
  othersourceidentify text,
  othertanf "stagv2014".no_yes,
  enrollmentid uuid,
  rentalassistanceongoing "stagv2014".no_yes,
  rentalassistancetemp "stagv2014".no_yes,
  snap "stagv2014".no_yes,
  tanfchildcare "stagv2014".no_yes,
  tanftransportation "stagv2014".no_yes,
  wic "stagv2014".no_yes,
  "project_group_code" character varying(8),
             "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "noncashbenefits_pkey" primary key (id),
  constraint "noncashbenefits_enrollmentid_fkey" foreign key (enrollmentid)
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "healthinsurance"

-- drop table "healthinsurance";

create table "stagv2014".healthinsurance
(
  "cobra" integer,
  "employerprovided" integer,
  "id" uuid not null,
  "insurancefromanysource" "stagv2014".five_val_dk_refused,
  "medicaid" "stagv2014".no_yes,
  "medicare" "stagv2014".no_yes,
  "nocobrareason" "stagv2014".no_health_insurance_reason,
  "noemployerprovidedreason" "stagv2014".no_health_insurance_reason,
  "nomedicaidreason" "stagv2014".no_health_insurance_reason,
  "nomedicarereason" "stagv2014".no_health_insurance_reason,
  "noprivatepayreason" "stagv2014".no_health_insurance_reason,
  "noschipreason" "stagv2014".no_health_insurance_reason,
  "nostatehealthinsreason" "stagv2014".no_health_insurance_reason,
  "novamedreason" "stagv2014".no_health_insurance_reason,
  "privatepay" "stagv2014".no_yes,
  "enrollmentid" uuid,
  "schip" "stagv2014".no_yes,
  "statehealthins" "stagv2014".no_yes,
  "vamedicalservices" "stagv2014".no_yes,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "healthinsurance_pkey" primary key ("id"),
  constraint "healthinsurance_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "stagv2014".exit
(
  "destination" "stagv2014".destination,
  "exitdate" timestamp,
  "id" uuid not null,
  "otherdestination" text,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exit_pkey" primary key ("id"),
  constraint "exit_enrollmentid_fkey" foreign key ("enrollmentid")
      references stagv2014.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table  "stagv2014".exithousingassessment
(
  "id" uuid not null,
  "exitid" uuid,
  "housingassessment" "stagv2014".housing_assmnt_exit,
  "subsidyinformation" "stagv2014".subsidy_information,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exithousingassessment_pkey" primary key ("id"),
  constraint "exithousingassessment_exitid_fkey" foreign key ("exitid")
      references stagv2014."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "exitplansactions"

-- drop table "exitplansactions";

create table  "stagv2014".exitplansactions
(
  "assistancemainstreambenefits" "stagv2014".no_yes_refused,
  "exitcounseling"  "stagv2014".no_yes_refused,
  "exitid" uuid,
  "id" uuid not null,
  "furtherfollowupservices" "stagv2014".no_yes_refused,
  "otheraftercareplanoraction" "stagv2014".no_yes_refused,
  "permanenthousingplacement" "stagv2014".no_yes_refused,
  "resourcepackage" "stagv2014".no_yes_refused,
  "scheduledfollowupcontacts" "stagv2014".no_yes_refused,
  "temporaryshelterplacement" "stagv2014".no_yes_refused,
  "writtenaftercareplan" "stagv2014".no_yes_refused,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exitplansactions_pkey" primary key ("id"),
  constraint "exitplansactions_exitid_fkey" foreign key ("exitid")
      references stagv2014."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


-- table: "housingassessmentdisposition"

-- drop table "housingassessmentdisposition";

create table "stagv2014".housingassessmentdisposition
(
  "assessmentdisposition" "stagv2014".assessment_disposition,
  "exitid" uuid,
  "id" uuid not null,
  "otherdisposition" text,
  "project_group_code" character varying(8),
  "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "housingassessmentdisposition_pkey" primary key ("id"),
  constraint "housingassessmentdisposition_exitid_fkey" foreign key ("exitid")
      references stagv2014."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "stagv2014".familyreunification
(
  "exitid" uuid,
  "familyreunificationachieved" "stagv2014".five_val_dk_refused,
  "id" uuid not null,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "familyreunification_pkey" primary key ("id"),
  constraint "familyreunification_exitid_fkey" foreign key ("exitid")
      references stagv2014."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- drop table "connectionwithsoar";

create table "stagv2014".connectionwithsoar
(
  "connectionwithsoar" integer,
  "id" uuid,
  "exitid" uuid,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "connectionwithsoar_pkey" primary key ("id"),
  constraint "connectionwithsoar_exitid_fkey" foreign key ("exitid")
      references stagv2014."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);
-- table: "projectcompletionstatus"

-- drop table "projectcompletionstatus";

create table "stagv2014".projectcompletionstatus
(
  earlyexitreason "stagv2014".early_exit_reason,
  exitid uuid,
  projectcompletionstatus "stagv2014".project_completion_status,
  id uuid not null,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "projectcompletionstatus_pkey" primary key (id),
  constraint "projectcompletionstatus_exitid_fkey" foreign key (exitid)
      references stagv2014."exit" ("id") match simple
      on update no action on delete no action
     )
with (
  oids=false
);

-- drop table "projectcompletionstatus";

CREATE TABLE "stagv2014".sync
(
  id uuid NOT NULL,
  sync_table character(100),
  status character(10),
  json text,
  date_created timestamp,
  date_updated timestamp,
  CONSTRAINT sync_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "stagv2014".bulk_upload
(
  id bigint NOT NULL,
  inputPath text,
  status character(10),
  description text,
  size bigint,
  export_id uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "stagv2014".bulk_upload_id_seq START 1;

create table "stagv2014".bulk_upload_mapping
(id uuid not null,
 source_id character(35) not null,
 destin_id uuid,
 bulk_upload_id bigint,
 table_name character varying(100),
 "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
     CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_mapping_pk PRIMARY KEY ("id")
);

create table "stagv2014".bulk_upload_activity
(
 id bigint not null,
 bulk_upload_id bigint not null,
 table_name character varying(100),
 records_processed bigint,
 description text,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
     CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES stagv2014.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_activity_pk PRIMARY KEY ("id")
);

CREATE SEQUENCE "stagv2014".bulk_upload_activity_id_seq START 1;